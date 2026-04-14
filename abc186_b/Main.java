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

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[][] A) {
    int H = A.length;
    int W = A[0].length;

    int min = Integer.MAX_VALUE;
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        min = Math.min(min, A[r][c]);
      }
    }

    int result = 0;
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        result += A[r][c] - min;
      }
    }

    return result;
  }
}