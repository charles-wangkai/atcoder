import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static long solve(int[] A) {
    long[] dp = new long[2];
    Arrays.fill(dp, -1);
    dp[0] = 0;

    for (int Ai : A) {
      long[] nextDp = new long[2];
      Arrays.fill(nextDp, -1);

      for (int i = 0; i < dp.length; ++i) {
        if (dp[i] != -1) {
          nextDp[i] = Math.max(nextDp[i], dp[i]);
          nextDp[1 - i] = Math.max(nextDp[1 - i], dp[i] + Ai + ((i % 2 == 1) ? Ai : 0));
        }
      }

      dp = nextDp;
    }

    return Math.max(dp[0], dp[1]);
  }
}