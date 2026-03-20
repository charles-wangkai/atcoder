import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    int result = 0;
    for (int beginIndex = 0; beginIndex < S.length(); ++beginIndex) {
      for (int endIndex = beginIndex; endIndex < S.length(); ++endIndex) {
        if (isPalindrome(S.substring(beginIndex, endIndex + 1))) {
          result = Math.max(result, endIndex - beginIndex + 1);
        }
      }
    }

    return result;
  }

  static boolean isPalindrome(String str) {
    return new StringBuilder(str).reverse().toString().equals(str);
  }
}