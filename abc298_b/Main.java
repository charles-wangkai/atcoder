import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] A = new int[N][N];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        A[r][c] = sc.nextInt();
      }
    }
    int[][] B = new int[N][N];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        B[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(A, B) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[][] A, int[][] B) {
    for (int i = 0; i < 4; ++i) {
      if (canCover(A, B)) {
        return true;
      }

      A = rotate(A);
    }

    return false;
  }

  static int[][] rotate(int[][] A) {
    int N = A.length;

    int[][] result = new int[N][N];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        result[r][c] = A[N - 1 - c][r];
      }
    }

    return result;
  }

  static boolean canCover(int[][] A, int[][] B) {
    int N = A.length;

    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        if (A[r][c] == 1 && B[r][c] == 0) {
          return false;
        }
      }
    }

    return true;
  }
}