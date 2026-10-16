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
    int result = 0;
    int sIndex = 0;
    int tIndex = 0;
    while (sIndex != S.length() || tIndex != T.length()) {
      if (sIndex == S.length()) {
        if (T.charAt(tIndex) != 'A') {
          return -1;
        }

        ++tIndex;
        ++result;
      } else if (tIndex == T.length()) {
        if (S.charAt(sIndex) != 'A') {
          return -1;
        }

        ++sIndex;
        ++result;
      } else if (S.charAt(sIndex) == T.charAt(tIndex)) {
        ++sIndex;
        ++tIndex;
      } else if (S.charAt(sIndex) == 'A') {
        ++sIndex;
        ++result;
      } else if (T.charAt(tIndex) == 'A') {
        ++tIndex;
        ++result;
      } else {
        return -1;
      }
    }

    return result;
  }
}