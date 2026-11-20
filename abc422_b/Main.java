import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

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

    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (grid[r][c] == '#') {
          int r_ = r;
          int c_ = c;
          int adjBlackCount =
              (int)
                  IntStream.range(0, R_OFFSETS.length)
                      .filter(i -> {
                        int adjR = r_ + R_OFFSETS[i];
                        int adjC = c_ + C_OFFSETS[i];

                        return adjR >= 0
                            && adjR < H
                            && adjC >= 0
                            && adjC < W
                            && grid[adjR][adjC] == '#';
                      })
                      .count();
          if (adjBlackCount != 2 && adjBlackCount != 4) {
            return false;
          }
        }
      }
    }

    return true;
  }
}