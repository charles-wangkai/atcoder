import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int R = sc.nextInt();
    int C = sc.nextInt();
    int sy = sc.nextInt();
    int sx = sc.nextInt();
    int gy = sc.nextInt();
    int gx = sc.nextInt();
    char[][] board = new char[R][C];
    for (int r = 0; r < R; ++r) {
      String line = sc.next();
      for (int c = 0; c < C; ++c) {
        board[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(board, sy, sx, gy, gx));

    sc.close();
  }

  static int solve(char[][] board, int sy, int sx, int gy, int gx) {
    int R = board.length;
    int C = board[0].length;

    int[][] distances = new int[R][C];
    for (int r = 0; r < R; ++r) {
      Arrays.fill(distances[r], -1);
    }
    distances[sy - 1][sx - 1] = 0;

    Queue<Point> queue = new ArrayDeque<>();
    queue.offer(new Point(sy - 1, sx - 1));

    while (true) {
      Point head = queue.poll();
      if (head.r() == gy - 1 && head.c() == gx - 1) {
        return distances[head.r()][head.c()];
      }

      for (int i = 0; i < R_OFFSETS.length; ++i) {
        int adjR = head.r() + R_OFFSETS[i];
        int adjC = head.c() + C_OFFSETS[i];
        if (board[adjR][adjC] == '.' && distances[adjR][adjC] == -1) {
          distances[adjR][adjC] = distances[head.r()][head.c()] + 1;
          queue.offer(new Point(adjR, adjC));
        }
      }
    }
  }
}

record Point(int r, int c) {}
