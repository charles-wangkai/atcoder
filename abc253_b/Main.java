import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

  static int solve(char[][] grid) {
    int H = grid.length;
    int W = grid[0].length;

    List<Point> pieces = new ArrayList<>();
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (grid[r][c] == 'o') {
          pieces.add(new Point(r, c));
        }
      }
    }

    return Math.abs(pieces.get(0).r() - pieces.get(1).r())
        + Math.abs(pieces.get(0).c() - pieces.get(1).c());
  }
}

record Point(int r, int c) {}
