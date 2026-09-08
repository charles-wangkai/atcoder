import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String T = sc.next();
    String U = sc.next();

    System.out.println(solve(T, U) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String T, String U) {
    return IntStream.rangeClosed(0, T.length() - U.length())
        .anyMatch(
            beginIndex ->
                IntStream.range(0, U.length())
                    .allMatch(
                        i ->
                            T.charAt(beginIndex + i) == '?'
                                || T.charAt(beginIndex + i) == U.charAt(i)));
  }
}