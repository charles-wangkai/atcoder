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
    for (int i = 0; i < S.length(); ++i) {
      for (int j = i + 1; j < S.length(); ++j) {
        for (int k = j + 1; k < S.length(); ++k) {
          if (S.charAt(i) == 'A' && S.charAt(j) == 'B' && S.charAt(k) == 'C' && j - i == k - j) {
            ++result;
          }
        }
      }
    }

    return result;
  }
}