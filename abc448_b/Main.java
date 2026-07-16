import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] C = new int[M];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextInt();
    }
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, C));

    sc.close();
  }

  static int solve(int[] A, int[] B, int[] C) {
    int result = 0;
    for (int i = 0; i < A.length; ++i) {
      int delta = Math.min(C[A[i] - 1], B[i]);
      result += delta;
      C[A[i] - 1] -= delta;
    }

    return result;
  }
}