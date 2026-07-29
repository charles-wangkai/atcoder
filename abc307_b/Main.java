import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String[] S) {
    for (int i = 0; i < S.length; ++i) {
      for (int j = 0; j < S.length; ++j) {
        if (j != i && isPalindrome(S[i] + S[j])) {
          return true;
        }
      }
    }

    return false;
  }

  static boolean isPalindrome(String s) {
    return new StringBuilder(s).reverse().toString().equals(s);
  }
}