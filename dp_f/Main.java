import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    String t = sc.next();

    System.out.println(solve(s, t));

    sc.close();
  }

  static String solve(String s, String t) {
    int[][] dp = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i <= s.length(); ++i) {
      for (int j = 0; j <= t.length(); ++j) {
        if (i != 0 && j != 0) {
          dp[i][j] =
              (s.charAt(i - 1) == t.charAt(j - 1))
                  ? (dp[i - 1][j - 1] + 1)
                  : Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    StringBuilder result = new StringBuilder();
    int sLength = s.length();
    int tLength = t.length();
    while (sLength != 0 && tLength != 0) {
      if (s.charAt(sLength - 1) == t.charAt(tLength - 1)) {
        result.append(s.charAt(sLength - 1));
        --sLength;
        --tLength;
      } else if (dp[sLength - 1][tLength] >= dp[sLength][tLength]) {
        --sLength;
      } else {
        --tLength;
      }
    }
    result.reverse();

    return result.toString();
  }
}