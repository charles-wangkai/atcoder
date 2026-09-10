import java.util.Scanner;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

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

    System.out.println(solve(grid) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(char[][] grid) {
    int H = grid.length;
    int W = grid[0].length;

    for (int r = 0; ; ++r) {
      for (int c = 0; c < W; ++c) {
        if (grid[r][c] == 's') {
          return search(grid, new boolean[H][W], r, c);
        }
      }
    }
  }

  static boolean search(char[][] grid, boolean[][] visited, int r, int c) {
    int H = grid.length;
    int W = grid[0].length;

    if (grid[r][c] == 'g') {
      return true;
    }

    if (visited[r][c]) {
      return false;
    }
    visited[r][c] = true;

    for (int i = 0; i < R_OFFSETS.length; ++i) {
      int adjR = r + R_OFFSETS[i];
      int adjC = c + C_OFFSETS[i];
      if (adjR >= 0
          && adjR < H
          && adjC >= 0
          && adjC < W
          && grid[adjR][adjC] != '#'
          && search(grid, visited, adjR, adjC)) {
        return true;
      }
    }

    return false;
  }
}