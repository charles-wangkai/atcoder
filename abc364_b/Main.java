import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int Si = sc.nextInt();
    int Sj = sc.nextInt();
    char[][] C = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        C[r][c] = line.charAt(c);
      }
    }
    String X = sc.next();

    System.out.println(solve(C, Si, Sj, X));

    sc.close();
  }

  static String solve(char[][] C, int Si, int Sj, String X) {
    int H = C.length;
    int W = C[0].length;

    int r = Si - 1;
    int c = Sj - 1;
    for (char direction : X.toCharArray()) {
      int nextR = r;
      int nextC = c;
      if (direction == 'L') {
        --nextC;
      } else if (direction == 'R') {
        ++nextC;
      } else if (direction == 'U') {
        --nextR;
      } else {
        ++nextR;
      }

      if (nextR >= 0 && nextR < H && nextC >= 0 && nextC < W && C[nextR][nextC] == '.') {
        r = nextR;
        c = nextC;
      }
    }

    return "%d %d".formatted(r + 1, c + 1);
  }
}