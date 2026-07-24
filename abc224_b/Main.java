import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int[][] A = new int[H][W];
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        A[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(A) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[][] A) {
    int H = A.length;
    int W = A[0].length;

    for (int r1 = 0; r1 < H; ++r1) {
      for (int r2 = r1 + 1; r2 < H; ++r2) {
        for (int c1 = 0; c1 < W; ++c1) {
          for (int c2 = c1 + 1; c2 < W; ++c2) {
            if (A[r1][c1] + A[r2][c2] > A[r2][c1] + A[r1][c2]) {
              return false;
            }
          }
        }
      }
    }

    return true;
  }
}