import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      long N = sc.nextLong();

      System.out.println(solve(N));
    }
  }

  static long solve(long N) {
    long result = 0;
    for (int A = 1; (long) A * A * A <= N; ++A) {
      for (int B = A; (long) A * B * B <= N; ++B) {
        result += N / ((long) A * B) - B + 1;
      }
    }

    return result;
  }
}