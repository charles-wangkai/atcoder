import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long X = sc.nextLong();
    int K = sc.nextInt();

    System.out.println(solve(X, K));

    sc.close();
  }

  static long solve(long X, int K) {
    for (int i = 1; i <= K; ++i) {
      X = (X + 5 * pow10(i - 1)) / pow10(i) * pow10(i);
    }

    return X;
  }

  static long pow10(int exponent) {
    long result = 1;
    for (int i = 0; i < exponent; ++i) {
      result *= 10;
    }

    return result;
  }
}