import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();
    char[][] grid = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        grid[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid, X, Y));

    sc.close();
  }

  static int solve(char[][] grid, int X, int Y) {
    return 1
        + computeVisibleNum(grid, X - 1, Y - 1, -1, 0)
        + computeVisibleNum(grid, X - 1, Y - 1, 0, 1)
        + computeVisibleNum(grid, X - 1, Y - 1, 1, 0)
        + computeVisibleNum(grid, X - 1, Y - 1, 0, -1);
  }

  static int computeVisibleNum(char[][] grid, int r, int c, int rOffset, int cOffset) {
    int H = grid.length;
    int W = grid[0].length;

    int result = 0;
    while (true) {
      r += rOffset;
      c += cOffset;
      if (!(r >= 0 && r < H && c >= 0 && c < W && grid[r][c] == '.')) {
        break;
      }

      ++result;
    }

    return result;
  }
}