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
    return S.equals(T)
        || IntStream.range(0, S.length() - 1)
            .anyMatch(
                i ->
                    "%s%c%c%s"
                        .formatted(
                            S.substring(0, i), S.charAt(i + 1), S.charAt(i), S.substring(i + 2))
                        .equals(T));
  }
}