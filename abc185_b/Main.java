import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int T = sc.nextInt();
    int[] A = new int[M];
    int[] B = new int[M];
    for (int i = 0; i < M; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(N, T, A, B) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N, int T, int[] A, int[] B) {
    int rest = N;
    for (int i = 0; i < A.length; ++i) {
      rest -= A[i] - ((i == 0) ? 0 : B[i - 1]);
      if (rest <= 0) {
        return false;
      }

      rest = Math.min(N, rest + (B[i] - A[i]));
    }

    return rest > T - B[B.length - 1];
  }
}