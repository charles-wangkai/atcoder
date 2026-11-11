import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] grid = new char[2][2];
    for (int r = 0; r < grid.length; ++r) {
      String line = sc.next();
      for (int c = 0; c < grid[r].length; ++c) {
        grid[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(grid) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(char[][] grid) {
    Map<Character, Point> letterToPoint = new HashMap<>();
    for (int r = 0; r < grid.length; ++r) {
      for (int c = 0; c < grid[r].length; ++c) {
        letterToPoint.put(grid[r][c], new Point(r, c));
      }
    }

    return letterToPoint.get('A').r() == letterToPoint.get('D').r()
        || letterToPoint.get('A').c() == letterToPoint.get('D').c();
  }
}

record Point(int r, int c) {}
