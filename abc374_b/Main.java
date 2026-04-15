import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T));

    sc.close();
  }

  static int solve(String S, String T) {
    for (int i = 0; ; ++i) {
      if (i == S.length() && i == T.length()) {
        return 0;
      }
      if (i == S.length() || i == T.length() || S.charAt(i) != T.charAt(i)) {
        return i + 1;
      }
    }
  }
}