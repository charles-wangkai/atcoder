import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    char[][] grid = new char[N][M];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < M; ++c) {
        grid[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid));

    sc.close();
  }

  static String solve(char[][] grid) {
    int N = grid.length;
    int M = grid[0].length;

    List<String> result = new ArrayList<>();
    for (int beginR = 0; beginR + 9 <= N; ++beginR) {
      for (int beginC = 0; beginC + 9 <= M; ++beginC) {
        if (isTaKCode(grid, beginR, beginC)) {
          result.add("%d %d".formatted(beginR + 1, beginC + 1));
        }
      }
    }

    return String.join("\n", result);
  }

  static boolean isTaKCode(char[][] grid, int beginR, int beginC) {
    return grid[beginR][beginC] == '#'
        && grid[beginR][beginC + 1] == '#'
        && grid[beginR][beginC + 2] == '#'
        && grid[beginR][beginC + 3] == '.'
        && grid[beginR + 1][beginC] == '#'
        && grid[beginR + 1][beginC + 1] == '#'
        && grid[beginR + 1][beginC + 2] == '#'
        && grid[beginR + 1][beginC + 3] == '.'
        && grid[beginR + 2][beginC] == '#'
        && grid[beginR + 2][beginC + 1] == '#'
        && grid[beginR + 2][beginC + 2] == '#'
        && grid[beginR + 2][beginC + 3] == '.'
        && grid[beginR + 3][beginC] == '.'
        && grid[beginR + 3][beginC + 1] == '.'
        && grid[beginR + 3][beginC + 2] == '.'
        && grid[beginR + 3][beginC + 3] == '.'
        && grid[beginR + 5][beginC + 5] == '.'
        && grid[beginR + 5][beginC + 6] == '.'
        && grid[beginR + 5][beginC + 7] == '.'
        && grid[beginR + 5][beginC + 8] == '.'
        && grid[beginR + 6][beginC + 5] == '.'
        && grid[beginR + 6][beginC + 6] == '#'
        && grid[beginR + 6][beginC + 7] == '#'
        && grid[beginR + 6][beginC + 8] == '#'
        && grid[beginR + 7][beginC + 5] == '.'
        && grid[beginR + 7][beginC + 6] == '#'
        && grid[beginR + 7][beginC + 7] == '#'
        && grid[beginR + 7][beginC + 8] == '#'
        && grid[beginR + 8][beginC + 5] == '.'
        && grid[beginR + 8][beginC + 6] == '#'
        && grid[beginR + 8][beginC + 7] == '#'
        && grid[beginR + 8][beginC + 8] == '#';
  }
}