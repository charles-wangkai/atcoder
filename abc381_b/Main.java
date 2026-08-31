import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    return S.length() % 2 == 0
        && IntStream.range(0, S.length() / 2).allMatch(i -> S.charAt(i * 2) == S.charAt(i * 2 + 1))
        && IntStream.range(0, S.length() / 2).map(i -> S.charAt(i * 2)).distinct().count()
            == S.length() / 2;
  }
}