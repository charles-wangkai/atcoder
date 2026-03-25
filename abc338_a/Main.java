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
    return IntStream.range(0, S.length())
        .allMatch(
            i ->
                (i == 0) ? Character.isUpperCase(S.charAt(i)) : Character.isLowerCase(S.charAt(i)));
  }
}