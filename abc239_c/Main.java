import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x1 = sc.nextInt();
    int y1 = sc.nextInt();
    int x2 = sc.nextInt();
    int y2 = sc.nextInt();

    System.out.println(solve(x1, y1, x2, y2) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int x1, int y1, int x2, int y2) {
    for (int dx = -2; dx <= 2; ++dx) {
      for (int dy = -2; dy <= 2; ++dy) {
        int x = x1 + dx;
        int y = y1 + dy;

        if (checkDistance(x, y, x1, y1) && checkDistance(x, y, x2, y2)) {
          return true;
        }
      }
    }

    return false;
  }

  static boolean checkDistance(int ax, int ay, int bx, int by) {
    return (long) (ax - bx) * (ax - bx) + (long) (ay - by) * (ay - by) == 5;
  }
}