import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      char[][] grid = new char[N][N];
      for (int r = 0; r < N; ++r) {
        String line = sc.next();
        for (int c = 0; c < N; ++c) {
          grid[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(grid));
    }
  }

  static long solve(char[][] grid) {
    int N = grid.length;

    int[] rowCounts = new int[N];
    int[] colCounts = new int[N];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        if (grid[r][c] == 'o') {
          ++rowCounts[r];
          ++colCounts[c];
        }
      }
    }

    long result = 0;
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        if (grid[r][c] == 'o') {
          result += (rowCounts[r] - 1) * (colCounts[c] - 1);
        }
      }
    }

    return result;
  }
}