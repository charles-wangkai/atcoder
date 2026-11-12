import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long X = sc.nextLong();
    long Y = sc.nextLong();
    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(X, Y, A, B));

    sc.close();
  }

  static long solve(long X, long Y, int A, int B) {
    long result = 0;
    int multiplyCount = 0;
    BigInteger exp = BigInteger.valueOf(X);
    while (exp.compareTo(BigInteger.valueOf(Y)) < 0) {
      result = Math.max(result, multiplyCount + (Y - 1 - exp.longValue()) / B);

      ++multiplyCount;
      exp = exp.multiply(BigInteger.valueOf(A));
    }

    return result;
  }
}