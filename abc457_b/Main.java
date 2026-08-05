import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] A = new int[N][];
    for (int i = 0; i < A.length; ++i) {
      int L = sc.nextInt();
      A[i] = new int[L];
      for (int j = 0; j < A[i].length; ++j) {
        A[i][j] = sc.nextInt();
      }
    }
    int X = sc.nextInt();
    int Y = sc.nextInt();

    System.out.println(solve(A, X, Y));

    sc.close();
  }

  static int solve(int[][] A, int X, int Y) {
    return A[X - 1][Y - 1];
  }
}