import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();
    char[][] S = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        S[r][c] = line.charAt(c);
      }
    }
    String T = sc.next();

    System.out.println(solve(S, X, Y, T));

    sc.close();
  }

  static String solve(char[][] S, int X, int Y, String T) {
    int r = X - 1;
    int c = Y - 1;
    Set<Point> houses = new HashSet<>();
    for (char direction : T.toCharArray()) {
      int adjR = r;
      int adjC = c;
      if (direction == 'U') {
        --adjR;
      } else if (direction == 'D') {
        ++adjR;
      } else if (direction == 'L') {
        --adjC;
      } else {
        ++adjC;
      }

      if (S[adjR][adjC] != '#') {
        if (S[adjR][adjC] == '@') {
          houses.add(new Point(adjR, adjC));
        }

        r = adjR;
        c = adjC;
      }
    }

    return "%d %d %d".formatted(r + 1, c + 1, houses.size());
  }
}

record Point(int r, int c) {}
