import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static long solve(long N) {
    long result = Long.MAX_VALUE;
    for (int i = 1; (long) i * i <= N; ++i) {
      if (N % i == 0) {
        result = Math.min(result, i + N / i - 2);
      }
    }

    return result;
  }
}