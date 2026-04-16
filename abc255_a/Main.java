import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int R = sc.nextInt();
    int C = sc.nextInt();
    int[][] A = new int[2][2];
    for (int r = 0; r < 2; ++r) {
      for (int c = 0; c < 2; ++c) {
        A[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(R, C, A));

    sc.close();
  }

  static int solve(int R, int C, int[][] A) {
    return A[R - 1][C - 1];
  }
}