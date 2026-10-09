import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};
  static final char[] ARROWS = {'v', '<', '^', '>'};

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

    Queue<Point> queue = new ArrayDeque<>();
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (grid[r][c] == 'E') {
          queue.offer(new Point(r, c));
        }
      }
    }
    while (!queue.isEmpty()) {
      Point head = queue.poll();
      for (int i = 0; i < R_OFFSETS.length; ++i) {
        int adjR = head.r() + R_OFFSETS[i];
        int adjC = head.c() + C_OFFSETS[i];
        if (adjR >= 0 && adjR < H && adjC >= 0 && adjC < W && grid[adjR][adjC] == '.') {
          grid[adjR][adjC] = ARROWS[i];
          queue.offer(new Point(adjR, adjC));
        }
      }
    }

    return Arrays.stream(grid).map(String::valueOf).collect(Collectors.joining("\n"));
  }
}

record Point(int r, int c) {}
