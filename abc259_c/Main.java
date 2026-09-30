import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S, String T) {
    List<Segment> sSegments = buildSegments(S);
    List<Segment> tSegments = buildSegments(T);

    return sSegments.size() == tSegments.size()
        && IntStream.range(0, sSegments.size())
            .allMatch(
                i ->
                    sSegments.get(i).letter() == tSegments.get(i).letter()
                        && (sSegments.get(i).count() == tSegments.get(i).count()
                            || (sSegments.get(i).count() != 1
                                && sSegments.get(i).count() < tSegments.get(i).count())));
  }

  static List<Segment> buildSegments(String str) {
    List<Segment> result = new ArrayList<>();
    char letter = 0;
    int count = 0;
    for (int i = 0; i <= str.length(); ++i) {
      if (i != str.length() && str.charAt(i) == letter) {
        ++count;
      } else {
        if (count != 0) {
          result.add(new Segment(letter, count));
        }

        if (i != str.length()) {
          letter = str.charAt(i);
          count = 1;
        }
      }
    }

    return result;
  }
}

record Segment(char letter, int count) {}
