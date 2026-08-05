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
    return S.length()
        + computeDistance(0, S.charAt(S.length() - 1) - '0')
        + IntStream.range(0, S.length() - 1)
            .map(i -> computeDistance(S.charAt(i + 1) - '0', S.charAt(i) - '0'))
            .sum();
  }

  static int computeDistance(int from, int to) {
    return (from <= to) ? (to - from) : (to + 10 - from);
  }
}