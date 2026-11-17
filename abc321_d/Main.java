import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      int P = sc.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < A.length; ++i) {
        A[i] = sc.nextInt();
      }
      int[] B = new int[M];
      for (int i = 0; i < B.length; ++i) {
        B[i] = sc.nextInt();
      }

      System.out.println(solve(A, B, P));
    }
  }

  static long solve(int[] A, int[] B, int P) {
    Arrays.sort(A);
    Arrays.sort(B);

    long result = 0;
    int bIndex = -1;
    long bPrefixSum = 0;
    for (int i = A.length - 1; i >= 0; --i) {
      while (bIndex != B.length - 1 && A[i] + B[bIndex + 1] <= P) {
        ++bIndex;
        bPrefixSum += B[bIndex];
      }

      result += bPrefixSum + (bIndex + 1L) * A[i] + (B.length - (bIndex + 1L)) * P;
    }

    return result;
  }
}