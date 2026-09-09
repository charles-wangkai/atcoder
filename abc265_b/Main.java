import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int T = sc.nextInt();
    int[] A = new int[N - 1];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] X = new int[M];
    int[] Y = new int[M];
    for (int i = 0; i < M; ++i) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }

    System.out.println(solve(A, X, Y, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] A, int[] X, int[] Y, int T) {
    long rest = T;
    int index = 0;
    for (int i = 0; i < A.length; ++i) {
      if (rest <= A[i]) {
        return false;
      }

      rest -= A[i];

      if (index != X.length && X[index] == i + 2) {
        rest += Y[index];
        ++index;
      }
    }

    return true;
  }
}