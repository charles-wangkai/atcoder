import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(char[][] grid) {
    int H = grid.length;
    int W = grid[0].length;

    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (grid[r][c] == '.') {
          grid[r][c] = '0';
          for (int dr = -1; dr <= 1; ++dr) {
            for (int dc = -1; dc <= 1; ++dc) {
              int adjR = r + dr;
              int adjC = c + dc;
              if (adjR >= 0 && adjR < H && adjC >= 0 && adjC < W && grid[adjR][adjC] == '#') {
                ++grid[r][c];
              }
            }
          }
        }
      }
    }

    return Arrays.stream(grid).map(String::valueOf).collect(Collectors.joining("\n"));
  }
}