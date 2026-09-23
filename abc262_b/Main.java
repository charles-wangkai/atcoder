import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] U = new int[M];
    int[] V = new int[M];
    for (int i = 0; i < M; ++i) {
      U[i] = sc.nextInt();
      V[i] = sc.nextInt();
    }

    System.out.println(solve(N, U, V));

    sc.close();
  }

  static int solve(int N, int[] U, int[] V) {
    boolean[][] adjMatrix = new boolean[N][N];
    for (int i = 0; i < U.length; ++i) {
      adjMatrix[U[i] - 1][V[i] - 1] = true;
      adjMatrix[V[i] - 1][U[i] - 1] = true;
    }

    int result = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        for (int k = j + 1; k < N; ++k) {
          if (adjMatrix[i][j] && adjMatrix[j][k] && adjMatrix[k][i]) {
            ++result;
          }
        }
      }
    }

    return result;
  }
}