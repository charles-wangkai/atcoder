import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int N = sc.nextInt();

    System.out.println(solve(H, W, N));

    sc.close();
  }

  static String solve(int H, int W, int N) {
    char[][] grid = new char[H][W];
    for (int r = 0; r < H; ++r) {
      Arrays.fill(grid[r], '.');
    }

    int r = 0;
    int c = 0;
    int direction = 0;
    for (int i = 0; i < N; ++i) {
      if (grid[r][c] == '.') {
        grid[r][c] = '#';
        direction = (direction + 1) % R_OFFSETS.length;
      } else {
        grid[r][c] = '.';
        direction = Math.floorMod(direction - 1, R_OFFSETS.length);
      }

      r = Math.floorMod(r + R_OFFSETS[direction], H);
      c = Math.floorMod(c + C_OFFSETS[direction], W);
    }

    return Arrays.stream(grid).map(String::valueOf).collect(Collectors.joining("\n"));
  }
}