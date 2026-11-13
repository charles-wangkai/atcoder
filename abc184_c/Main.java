import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int r1 = sc.nextInt();
    int c1 = sc.nextInt();
    int r2 = sc.nextInt();
    int c2 = sc.nextInt();

    System.out.println(solve(r1, c1, r2, c2));

    sc.close();
  }

  static int solve(int r1, int c1, int r2, int c2) {
    if (r1 == r2 && c1 == c2) {
      return 0;
    }
    if (r1 + c1 == r2 + c2 || r1 - c1 == r2 - c2 || Math.abs(r1 - r2) + Math.abs(c1 - c2) <= 3) {
      return 1;
    }
    if (Math.floorMod(r1 + c1, 2) == Math.floorMod(r2 + c2, 2)) {
      return 2;
    }

    int result = Integer.MAX_VALUE;
    for (int dr = -3; dr <= 3; ++dr) {
      for (int dc = -3; dc <= 3; ++dc) {
        if (Math.floorMod(dr + dc, 2) == 1) {
          result = Math.min(result, 1 + solve(r1 + dr, c1 + dc, r2, c2));
        }
      }
    }

    return result;
  }
}