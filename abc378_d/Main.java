import java.util.Scanner;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int H = sc.nextInt();
      int W = sc.nextInt();
      int K = sc.nextInt();
      char[][] S = new char[H][W];
      for (int r = 0; r < H; ++r) {
        String line = sc.next();
        for (int c = 0; c < W; ++c) {
          S[r][c] = line.charAt(c);
        }
      }

      System.out.println(solve(S, K));
    }
  }

  static int solve(char[][] S, int K) {
    int H = S.length;
    int W = S[0].length;

    int result = 0;
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        result += search(S, new boolean[H][W], K, r, c);
      }
    }

    return result;
  }

  static int search(char[][] S, boolean[][] visited, int rest, int r, int c) {
    int H = S.length;
    int W = S[0].length;

    if (!(r >= 0 && r < H && c >= 0 && c < W) || S[r][c] == '#' || visited[r][c]) {
      return 0;
    }
    if (rest == 0) {
      return 1;
    }

    visited[r][c] = true;

    int result = 0;
    for (int i = 0; i < R_OFFSETS.length; ++i) {
      result += search(S, visited, rest - 1, r + R_OFFSETS[i], c + C_OFFSETS[i]);
    }

    visited[r][c] = false;

    return result;
  }
}