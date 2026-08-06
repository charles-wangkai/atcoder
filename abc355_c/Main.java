import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int T = sc.nextInt();
    int[] A = new int[T];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(N, A));

    sc.close();
  }

  static int solve(int N, int[] A) {
    int[] rowCounts = new int[N];
    int[] colCounts = new int[N];
    int diagonalCount1 = 0;
    int diagonalCount2 = 0;
    for (int i = 0; i < A.length; ++i) {
      int r = (A[i] - 1) / N;
      int c = (A[i] - 1) % N;

      ++rowCounts[r];
      if (rowCounts[r] == N) {
        return i + 1;
      }

      ++colCounts[c];
      if (colCounts[c] == N) {
        return i + 1;
      }

      if (r == c) {
        ++diagonalCount1;
        if (diagonalCount1 == N) {
          return i + 1;
        }
      }

      if (r + c == N - 1) {
        ++diagonalCount2;
        if (diagonalCount2 == N) {
          return i + 1;
        }
      }
    }

    return -1;
  }
}