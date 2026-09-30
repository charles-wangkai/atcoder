import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(H, A, B));

    sc.close();
  }

  static int solve(int H, int[] A, int[] B) {
    int[] dp = new int[H + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[H] = 0;

    int result = Integer.MAX_VALUE;
    for (int i = H; i >= 1; --i) {
      if (dp[i] != Integer.MAX_VALUE) {
        for (int j = 0; j < A.length; ++j) {
          int nextHealth = i - A[j];
          int nextCost = dp[i] + B[j];
          if (nextHealth <= 0) {
            result = Math.min(result, nextCost);
          } else {
            dp[nextHealth] = Math.min(dp[nextHealth], nextCost);
          }
        }
      }
    }

    return result;
  }
}