import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] A = new int[64];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static BigInteger solve(int[] A) {
    BigInteger result = BigInteger.ZERO;
    for (int i = A.length - 1; i >= 0; --i) {
      result = result.multiply(BigInteger.TWO).add(BigInteger.valueOf(A[i]));
    }

    return result;
  }
}