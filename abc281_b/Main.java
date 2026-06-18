import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    return S.length() == 8
        && check(S.charAt(0), 'A', 'Z')
        && check(S.charAt(1), '1', '9')
        && check(S.charAt(2), '0', '9')
        && check(S.charAt(3), '0', '9')
        && check(S.charAt(4), '0', '9')
        && check(S.charAt(5), '0', '9')
        && check(S.charAt(6), '0', '9')
        && check(S.charAt(7), 'A', 'Z');
  }

  static boolean check(char c, char min, char max) {
    return c >= min && c <= max;
  }
}