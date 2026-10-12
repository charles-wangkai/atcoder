import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final String TARGET = "snuke";

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
    int W = grid[0].length;

    for (int beginR = 0; ; ++beginR) {
      for (int beginC = 0; beginC < W; ++beginC) {
        for (int dr = -1; dr <= 1; ++dr) {
          for (int dc = -1; dc <= 1; ++dc) {
            if ((dr != 0 || dc != 0) && check(grid, beginR, beginC, dr, dc)) {
              int beginR_ = beginR;
              int beginC_ = beginC;
              int dr_ = dr;
              int dc_ = dc;
              return IntStream.range(0, TARGET.length())
                  .mapToObj(i -> "%d %d".formatted(beginR_ + i * dr_ + 1, beginC_ + i * dc_ + 1))
                  .collect(Collectors.joining("\n"));
            }
          }
        }
      }
    }
  }

  static boolean check(char[][] grid, int beginR, int beginC, int dr, int dc) {
    int H = grid.length;
    int W = grid[0].length;

    return IntStream.range(0, TARGET.length())
        .allMatch(
            i -> {
              int r = beginR + i * dr;
              int c = beginC + i * dc;

              return r >= 0 && r < H && c >= 0 && c < W && grid[r][c] == TARGET.charAt(i);
            });
  }
}