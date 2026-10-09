import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[] A) {
    return IntStream.range(0, 1 << (A.length - 1))
        .map(mask -> computeOrXor(A, mask))
        .min()
        .getAsInt();
  }

  static int computeOrXor(int[] A, int mask) {
    int xor = 0;
    int or = 0;
    for (int i = 0; i < A.length; ++i) {
      or |= A[i];

      if (i == A.length - 1 || ((mask >> i) & 1) == 1) {
        xor ^= or;
        or = 0;
      }
    }

    return xor;
  }
}