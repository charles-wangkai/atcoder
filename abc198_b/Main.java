import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N) {
    String s = String.valueOf(N);

    int endIndex = s.length() - 1;
    while (endIndex != -1 && s.charAt(endIndex) == '0') {
      --endIndex;
    }

    return isPalindrome(s.substring(0, endIndex + 1));
  }

  static boolean isPalindrome(String str) {
    return new StringBuilder(str).reverse().toString().equals(str);
  }
}