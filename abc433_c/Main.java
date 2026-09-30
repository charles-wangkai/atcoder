import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    List<Segment> segments = new ArrayList<>();
    int digit = -1;
    int count = 0;
    for (int i = 0; i <= S.length(); ++i) {
      if (i != S.length() && S.charAt(i) - '0' == digit) {
        ++count;
      } else {
        if (count != 0) {
          segments.add(new Segment(digit, count));
        }

        if (i != S.length()) {
          digit = S.charAt(i) - '0';
          count = 1;
        }
      }
    }

    return IntStream.range(0, segments.size() - 1)
        .filter(i -> segments.get(i).digit() + 1 == segments.get(i + 1).digit())
        .map(i -> Math.min(segments.get(i).count(), segments.get(i + 1).count()))
        .sum();
  }
}

record Segment(int digit, int count) {}
