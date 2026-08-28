import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] x = new int[M][];
    for (int i = 0; i < x.length; ++i) {
      int k = sc.nextInt();
      x[i] = new int[k];
      for (int j = 0; j < x[i].length; ++j) {
        x[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(N, x) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N, int[][] x) {
    boolean[][] matrix = new boolean[N][N];
    for (int[] xi : x) {
      for (int p : xi) {
        for (int q : xi) {
          matrix[p - 1][q - 1] = true;
        }
      }
    }

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (!matrix[i][j]) {
          return false;
        }
      }
    }

    return true;
  }
}