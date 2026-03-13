import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final long LIMIT = 1_000_000_000_000_000_000L;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long[] A = new long[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextLong();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static long solve(long[] A) {
    if (Arrays.stream(A).anyMatch(Ai -> Ai == 0)) {
      return 0;
    }

    long product = 1;
    for (long Ai : A) {
      if (Ai >= Math.ceilDiv(LIMIT + 1, product)) {
        return -1;
      }

      product *= Ai;
    }

    return product;
  }
}