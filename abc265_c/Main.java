import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    char[][] G = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        G[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(G));

    sc.close();
  }

  static String solve(char[][] G) {
    int H = G.length;
    int W = G[0].length;

    boolean[][] visited = new boolean[H][W];
    visited[0][0] = true;

    int r = 0;
    int c = 0;
    while (true) {
      int nextR = r;
      int nextC = c;
      if (G[r][c] == 'U') {
        --nextR;
      } else if (G[r][c] == 'D') {
        ++nextR;
      } else if (G[r][c] == 'L') {
        --nextC;
      } else {
        ++nextC;
      }

      if (!(nextR >= 0 && nextR < H && nextC >= 0 && nextC < W)) {
        return "%d %d".formatted(r + 1, c + 1);
      }

      if (visited[nextR][nextC]) {
        return "-1";
      }
      visited[nextR][nextC] = true;

      r = nextR;
      c = nextC;
    }
  }
}