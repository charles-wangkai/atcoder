import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    char[][] S = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        S[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(char[][] S) {
    int H = S.length;
    int W = S[0].length;

    int result = 0;
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (S[r][c] == '.') {
          result = Math.max(result, computeMaxDistance(S, r, c));
        }
      }
    }

    return result;
  }

  static int computeMaxDistance(char[][] S, int startR, int startC) {
    int H = S.length;
    int W = S[0].length;

    int[][] distances = new int[H][W];
    for (int r = 0; r < H; ++r) {
      Arrays.fill(distances[r], -1);
    }
    distances[startR][startC] = 0;

    Queue<Point> queue = new ArrayDeque<>();
    queue.offer(new Point(startR, startC));

    while (!queue.isEmpty()) {
      Point head = queue.poll();
      for (int i = 0; i < R_OFFSETS.length; ++i) {
        int adjR = head.r() + R_OFFSETS[i];
        int adjC = head.c() + C_OFFSETS[i];
        if (adjR >= 0
            && adjR < H
            && adjC >= 0
            && adjC < W
            && S[adjR][adjC] == '.'
            && distances[adjR][adjC] == -1) {
          distances[adjR][adjC] = distances[head.r()][head.c()] + 1;
          queue.offer(new Point(adjR, adjC));
        }
      }
    }

    int result = Integer.MIN_VALUE;
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        result = Math.max(result, distances[r][c]);
      }
    }

    return result;
  }
}

record Point(int r, int c) {}
