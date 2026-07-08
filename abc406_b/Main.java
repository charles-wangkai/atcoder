import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    long[] A = new long[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextLong();
    }

    System.out.println(solve(A, K));

    sc.close();
  }

  static long solve(long[] A, int K) {
    long result = 1;
    for (long Ai : A) {
      if (Ai > Long.MAX_VALUE / result) {
        result = 1;
      } else {
        long product = result * Ai;
        if (String.valueOf(product).length() > K) {
          result = 1;
        } else {
          result = product;
        }
      }
    }

    return result;
  }
}