import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    return isPalindrome(S)
        && isPalindrome(S.substring(0, S.length() / 2))
        && isPalindrome(S.substring(S.length() / 2 + 1));
  }

  static boolean isPalindrome(String str) {
    return new StringBuilder(str).reverse().toString().equals(str);
  }
}