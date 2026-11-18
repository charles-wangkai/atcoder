import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int X = sc.nextInt();
      int[] A = new int[N];
      int[] B = new int[N];
      for (int i = 0; i < N; ++i) {
        A[i] = sc.nextInt();
        B[i] = sc.nextInt();
      }

      System.out.println(solve(A, B, X));
    }
  }

  static long solve(int[] A, int[] B, int X) {
    long result = Long.MAX_VALUE;
    long sum = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < A.length && i < X; ++i) {
      sum += A[i] + B[i];
      min = Math.min(min, B[i]);

      result = Math.min(result, sum + (X - (i + 1L)) * min);
    }

    return result;
  }
}