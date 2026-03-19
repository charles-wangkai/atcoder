import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static long solve(int[] a) {
    int N = a.length;

    long[] prefixSums = new long[a.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + a[i - 1];
    }

    long[][] dp = new long[N][N];
    for (int length = 2; length <= N; ++length) {
      for (int beginIndex = 0; beginIndex + length <= N; ++beginIndex) {
        int endIndex = beginIndex + length - 1;

        dp[beginIndex][endIndex] = Long.MAX_VALUE;
        for (int i = beginIndex; i < endIndex; ++i) {
          dp[beginIndex][endIndex] =
              Math.min(
                  dp[beginIndex][endIndex],
                  dp[beginIndex][i]
                      + dp[i + 1][endIndex]
                      + computeRangeSum(prefixSums, beginIndex, i)
                      + computeRangeSum(prefixSums, i + 1, endIndex));
        }
      }
    }

    return dp[0][N - 1];
  }

  static long computeRangeSum(long[] prefixSums, int beginIndex, int endIndex) {
    return prefixSums[endIndex + 1] - prefixSums[beginIndex];
  }
}