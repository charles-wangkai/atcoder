import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    char[][] grid = new char[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        grid[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(char[][] grid) {
    int N = grid.length;

    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        for (int dr = -1; dr <= 1; ++dr) {
          for (int dc = -1; dc <= 1; ++dc) {
            if ((dr != 0 || dc != 0) && check(grid, r, c, dr, dc)) {
              return true;
            }
          }
        }
      }
    }

    return false;
  }

  static boolean check(char[][] grid, int r, int c, int dr, int dc) {
    int N = grid.length;

    int whiteCount = 0;
    for (int i = 0; i < 6; ++i) {
      if (!(r >= 0 && r < N && c >= 0 && c < N)) {
        return false;
      }

      if (grid[r][c] == '.') {
        ++whiteCount;
      }

      r += dr;
      c += dc;
    }

    return whiteCount <= 2;
  }
}