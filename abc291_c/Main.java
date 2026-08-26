import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    Set<Point> seen = new HashSet<>();
    seen.add(new Point(0, 0));
    int x = 0;
    int y = 0;
    for (char move : S.toCharArray()) {
      if (move == 'R') {
        ++x;
      } else if (move == 'L') {
        --x;
      } else if (move == 'U') {
        ++y;
      } else {
        --y;
      }

      Point point = new Point(x, y);
      if (!seen.add(point)) {
        return true;
      }
    }

    return false;
  }
}

record Point(int x, int y) {}
