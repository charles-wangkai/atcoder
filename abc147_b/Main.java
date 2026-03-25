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
    for (int i = 0, j = S.length() - 1; i < j; ++i, --j) {
      if (S.charAt(i) != S.charAt(j)) {
        ++result;
      }
    }

    return result;
  }
}