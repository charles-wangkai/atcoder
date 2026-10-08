import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    char[][] grid = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        grid[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid));

    sc.close();
  }

  static int solve(char[][] grid) {
    int H = grid.length;
    int W = grid[0].length;

    int result = 0;
    for (int minR = 0; minR < H; ++minR) {
      for (int maxR = minR; maxR < H; ++maxR) {
        for (int minC = 0; minC < W; ++minC) {
          for (int maxC = minC; maxC < W; ++maxC) {
            if (isSymmetrical(grid, minR, maxR, minC, maxC)) {
              ++result;
            }
          }
        }
      }
    }

    return result;
  }

  static boolean isSymmetrical(char[][] grid, int minR, int maxR, int minC, int maxC) {
    for (int r = minR; r <= maxR; ++r) {
      for (int c = minC; c <= maxC; ++c) {
        if (grid[r][c] != grid[minR + maxR - r][minC + maxC - c]) {
          return false;
        }
      }
    }

    return true;
  }
}