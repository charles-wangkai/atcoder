import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T));

    sc.close();
  }

  static int solve(String S, String T) {
    return IntStream.rangeClosed(0, S.length() - T.length())
        .map(
            beginIndex ->
                (int)
                    IntStream.range(0, T.length())
                        .filter(i -> S.charAt(beginIndex + i) != T.charAt(i))
                        .count())
        .min()
        .getAsInt();
  }
}