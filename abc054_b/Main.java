import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    char[][] A = new char[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        A[r][c] = line.charAt(c);
      }
    }
    char[][] B = new char[M][M];
    for (int r = 0; r < M; ++r) {
      String line = sc.next();
      for (int c = 0; c < M; ++c) {
        B[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(A, B) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(char[][] A, char[][] B) {
    int N = A.length;
    int M = B.length;

    for (int minR = 0; minR + M <= N; ++minR) {
      for (int minC = 0; minC + M <= N; ++minC) {
        if (isSame(A, B, minR, minC)) {
          return true;
        }
      }
    }

    return false;
  }

  static boolean isSame(char[][] A, char[][] B, int minR, int minC) {
    int M = B.length;

    for (int r = 0; r < M; ++r) {
      for (int c = 0; c < M; ++c) {
        if (A[minR + r][minC + c] != B[r][c]) {
          return false;
        }
      }
    }

    return true;
  }
}