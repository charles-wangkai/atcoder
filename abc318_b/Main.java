import java.util.Scanner;

public class Main {
  static final int LIMIT = 100;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    int[] C = new int[N];
    int[] D = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
      C[i] = sc.nextInt();
      D[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, C, D));

    sc.close();
  }

  static int solve(int[] A, int[] B, int[] C, int[] D) {
    boolean[][] covered = new boolean[LIMIT][LIMIT];
    for (int i = 0; i < A.length; ++i) {
      for (int r = C[i]; r < D[i]; ++r) {
        for (int c = A[i]; c < B[i]; ++c) {
          covered[r][c] = true;
        }
      }
    }

    int result = 0;
    for (int r = 0; r < LIMIT; ++r) {
      for (int c = 0; c < LIMIT; ++c) {
        if (covered[r][c]) {
          ++result;
        }
      }
    }

    return result;
  }
}