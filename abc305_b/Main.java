import static java.util.Map.entry;

import java.util.Map;
import java.util.Scanner;

public class Main {
  static final Map<Character, Integer> POINT_TO_LOCATION =
      Map.ofEntries(
          entry('A', 0),
          entry('B', 3),
          entry('C', 4),
          entry('D', 8),
          entry('E', 9),
          entry('F', 14),
          entry('G', 23));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char p = sc.next().charAt(0);
    char q = sc.next().charAt(0);

    System.out.println(solve(p, q));

    sc.close();
  }

  static int solve(char p, char q) {
    return Math.abs(POINT_TO_LOCATION.get(p) - POINT_TO_LOCATION.get(q));
  }
}