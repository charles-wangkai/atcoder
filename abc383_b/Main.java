import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int D = sc.nextInt();
    char[][] cells = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        cells[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(cells, D));

    sc.close();
  }

  static int solve(char[][] cells, int D) {
    int H = cells.length;
    int W = cells[0].length;

    int result = 0;
    for (int location1 = 0; location1 < H * W; ++location1) {
      int hr1 = location1 / W;
      int hc1 = location1 % W;
      if (cells[hr1][hc1] == '.') {
        for (int location2 = location1 + 1; location2 < H * W; ++location2) {
          int hr2 = location2 / W;
          int hc2 = location2 % W;
          if (cells[hr2][hc2] == '.') {
            result = Math.max(result, computeHumidifiedNum(cells, D, hr1, hc1, hr2, hc2));
          }
        }
      }
    }

    return result;
  }

  static int computeHumidifiedNum(char[][] cells, int D, int hr1, int hc1, int hr2, int hc2) {
    int H = cells.length;
    int W = cells[0].length;

    int result = 0;
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (cells[r][c] == '.'
            && (computeDistance(r, c, hr1, hc1) <= D || computeDistance(r, c, hr2, hc2) <= D)) {
          ++result;
        }
      }
    }

    return result;
  }

  static int computeDistance(int r1, int c1, int r2, int c2) {
    return Math.abs(r1 - r2) + Math.abs(c1 - c2);
  }
}
