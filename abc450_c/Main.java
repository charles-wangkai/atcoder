import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int H = Integer.parseInt(st.nextToken());
    int W = Integer.parseInt(st.nextToken());
    char[][] S = new char[H][W];
    for (int r = 0; r < H; ++r) {
      st = new StringTokenizer(br.readLine());
      String line = st.nextToken();
      for (int c = 0; c < W; ++c) {
        S[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(S));
  }

  static int solve(char[][] S) {
    int H = S.length;
    int W = S[0].length;

    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if ((r == 0 || r == H - 1 || c == 0 || c == W - 1) && S[r][c] == '.') {
          fill(S, r, c);
        }
      }
    }

    int result = 0;
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (S[r][c] == '.') {
          fill(S, r, c);
          ++result;
        }
      }
    }

    return result;
  }

  static void fill(char[][] S, int r, int c) {
    int H = S.length;
    int W = S[0].length;

    S[r][c] = '#';

    for (int i = 0; i < R_OFFSETS.length; ++i) {
      int adjR = r + R_OFFSETS[i];
      int adjC = c + C_OFFSETS[i];
      if (adjR >= 0 && adjR < H && adjC >= 0 && adjC < W && S[adjR][adjC] == '.') {
        fill(S, adjR, adjC);
      }
    }
  }
}