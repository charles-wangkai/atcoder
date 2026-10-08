import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long K = sc.nextLong();
    int[][] A = new int[N][];
    for (int i = 0; i < A.length; ++i) {
      int L = sc.nextInt();
      A[i] = new int[L];
      for (int j = 0; j < A[i].length; ++j) {
        A[i][j] = sc.nextInt();
      }
    }
    int[] C = new int[N];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextInt();
    }

    System.out.println(solve(A, C, K));

    sc.close();
  }

  static int solve(int[][] A, int[] C, long K) {
    for (int i = 0; ; ++i) {
      if (K <= (long) A[i].length * C[i]) {
        return A[i][(int) ((K - 1) % A[i].length)];
      }

      K -= (long) A[i].length * C[i];
    }
  }
}