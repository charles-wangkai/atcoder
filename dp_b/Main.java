import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] h = new int[N];
    for (int i = 0; i < h.length; ++i) {
      h[i] = sc.nextInt();
    }

    System.out.println(solve(h, K));

    sc.close();
  }

  static int solve(int[] h, int K) {
    int[] dp = new int[h.length];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 0; i < dp.length; ++i) {
      for (int j = i - 1; j >= 0 && i - j <= K; --j) {
        dp[i] = Math.min(dp[i], dp[j] + Math.abs(h[i] - h[j]));
      }
    }

    return dp[dp.length - 1];
  }
}