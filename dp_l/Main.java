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

    long[][] dp = new long[N][N];
    for (int length = 1; length <= N; ++length) {
      for (int beginIndex = 0; beginIndex + length <= N; ++beginIndex) {
        int endIndex = beginIndex + length - 1;

        dp[beginIndex][endIndex] =
            (length == 1)
                ? a[beginIndex]
                : Math.max(
                    a[beginIndex] - dp[beginIndex + 1][endIndex],
                    a[endIndex] - dp[beginIndex][endIndex - 1]);
      }
    }

    return dp[0][N - 1];
  }
}
