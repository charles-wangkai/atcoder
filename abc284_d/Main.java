import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      long N = sc.nextLong();

      System.out.println(solve(N));
    }

    sc.close();
  }

  static String solve(long N) {
    for (int i = 2; ; ++i) {
      if (N % ((long) i * i) == 0) {
        return "%d %d".formatted(i, N / ((long) i * i));
      }
      if (N % i == 0) {
        return "%d %d".formatted(computeRoot(N / i), i);
      }
    }
  }

  static int computeRoot(long x) {
    return (int) Math.round(Math.sqrt(x));
  }
}