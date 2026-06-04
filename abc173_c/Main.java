import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int K = sc.nextInt();
    char[][] grid = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        grid[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid, K));

    sc.close();
  }

  static int solve(char[][] grid, int K) {
    int H = grid.length;
    int W = grid[0].length;

    int result = 0;
    for (int rMask = 0; rMask < 1 << H; ++rMask) {
      for (int cMask = 0; cMask < 1 << W; ++cMask) {
        int blackCount = 0;
        for (int r = 0; r < H; ++r) {
          for (int c = 0; c < W; ++c) {
            if (((rMask >> r) & 1) == 0 && ((cMask >> c) & 1) == 0 && grid[r][c] == '#') {
              ++blackCount;
            }
          }
        }

        if (blackCount == K) {
          ++result;
        }
      }
    }

    return result;
  }
}