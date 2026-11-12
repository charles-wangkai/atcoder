import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    long K = sc.nextLong();

    System.out.println(solve(N, M, K));

    sc.close();
  }

  static long solve(int N, int M, long K) {
    long result = -1;
    long lower = 0;
    long upper = Long.MAX_VALUE;
    while (lower <= upper) {
      long middle = lower + (upper - lower) / 2;
      if (check(N, M, K, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int N, int M, long K, long limit) {
    return limit / N + limit / M - limit / lcm(N, M) * 2 >= K;
  }

  static long lcm(int x, int y) {
    return (long) x / gcd(x, y) * y;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}