import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    sc.nextInt();
    String T = sc.next();
    char[][] cells = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        cells[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(cells, T));

    sc.close();
  }

  static int solve(char[][] cells, String T) {
    int H = cells.length;
    int W = cells[0].length;

    int result = 0;
    for (int r = 0; r < H; ++r) {
      for (int c = 0; c < W; ++c) {
        if (cells[r][c] == '.' && check(cells, T, r, c)) {
          ++result;
        }
      }
    }

    return result;
  }

  static boolean check(char[][] cells, String T, int r, int c) {
    for (char move : T.toCharArray()) {
      if (move == 'L') {
        --c;
      } else if (move == 'R') {
        ++c;
      } else if (move == 'U') {
        --r;
      } else {
        ++r;
      }

      if (cells[r][c] == '#') {
        return false;
      }
    }

    return true;
  }
}