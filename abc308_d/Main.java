import java.util.Scanner;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};
  static final String TARGET = "snuke";

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int H = sc.nextInt();
      int W = sc.nextInt();
      char[][] grid = new char[H][W];
      for (int r = 0; r < H; ++r) {
        String line = sc.next();
        for (int c = 0; c < W; ++c) {
          grid[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(grid) ? "Yes" : "No");
    }
  }

  static boolean solve(char[][] grid) {
    int H = grid.length;
    int W = grid[0].length;

    return search(grid, new boolean[H][W], 0, 0, 0);
  }

  static boolean search(char[][] grid, boolean[][] visited, int index, int r, int c) {
    int H = grid.length;
    int W = grid[0].length;

    if (!(r >= 0 && r < H && c >= 0 && c < W)
        || visited[r][c]
        || grid[r][c] != TARGET.charAt(index)) {
      return false;
    }
    if (r == H - 1 && c == W - 1) {
      return true;
    }

    visited[r][c] = true;

    for (int i = 0; i < R_OFFSETS.length; ++i) {
      if (search(
          grid, visited, (index + 1) % TARGET.length(), r + R_OFFSETS[i], c + C_OFFSETS[i])) {
        return true;
      }
    }

    return false;
  }
}