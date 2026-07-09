import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] a = new int[M][N];
    for (int i = 0; i < M; ++i) {
      for (int j = 0; j < N; ++j) {
        a[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[][] a) {
    int N = a[0].length;

    boolean[][] adjs = new boolean[N][N];
    for (int[] ai : a) {
      for (int j = 0; j < ai.length - 1; ++j) {
        adjs[ai[j] - 1][ai[j + 1] - 1] = true;
        adjs[ai[j + 1] - 1][ai[j] - 1] = true;
      }
    }

    int result = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        if (!adjs[i][j]) {
          ++result;
        }
      }
    }

    return result;
  }
}