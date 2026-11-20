import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int[] R_OFFSETS = {-1, -1, 1, 1};
  static final int[] C_OFFSETS = {-1, 1, 1, -1};

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

      System.out.println(solve(grid));
    }
  }

  static String solve(char[][] grid) {
    int H = grid.length;
    int W = grid[0].length;

    int[] result = new int[Math.min(H, W)];
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (grid[r][c] == '#') {
          ++result[fill(grid, r, c) / 4 - 1];
        }
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static int fill(char[][] grid, int r, int c) {
    int H = grid.length;
    int W = grid[0].length;

    grid[r][c] = '.';

    int result = 1;
    for (int i = 0; i < R_OFFSETS.length; ++i) {
      int adjR = r + R_OFFSETS[i];
      int adjC = c + C_OFFSETS[i];
      if (adjR >= 0 && adjR < H && adjC >= 0 && adjC < W && grid[adjR][adjC] == '#') {
        result += fill(grid, adjR, adjC);
      }
    }

    return result;
  }
}