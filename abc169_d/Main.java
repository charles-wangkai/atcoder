import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(long N) {
    int result = 0;
    for (int i = 2; (long) i * i <= N; ++i) {
      int exponent = 0;
      while (N % i == 0) {
        ++exponent;
        N /= i;
      }

      for (int j = 1; exponent >= j; ++j) {
        ++result;
        exponent -= j;
      }
    }
    if (N != 1) {
      ++result;
    }

    return result;
  }
}