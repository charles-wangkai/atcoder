import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int SUM_LIMIT = 2500;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int A = sc.nextInt();
    int[] x = new int[N];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }

    System.out.println(solve(x, A));

    sc.close();
  }

  static long solve(int[] x, int A) {
    long[][] dp = new long[x.length + 1][SUM_LIMIT + 1];
    dp[0][0] = 1;
    for (int xi : x) {
      long[][] nextDp = new long[x.length + 1][SUM_LIMIT + 1];
      for (int i = 0; i <= x.length; ++i) {
        for (int j = 0; j <= SUM_LIMIT; ++j) {
          nextDp[i][j] = dp[i][j];

          if (i != 0 && j >= xi) {
            nextDp[i][j] += dp[i - 1][j - xi];
          }
        }
      }

      dp = nextDp;
    }

    long[][] dp_ = dp;
    return IntStream.rangeClosed(1, x.length).mapToLong(i -> dp_[i][A * i]).sum();
  }
}