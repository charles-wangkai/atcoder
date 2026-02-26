import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int sx = sc.nextInt();
    int sy = sc.nextInt();
    int tx = sc.nextInt();
    int ty = sc.nextInt();

    System.out.println(solve(sx, sy, tx, ty));

    sc.close();
  }

  static String solve(int sx, int sy, int tx, int ty) {
    int dx = tx - sx;
    int dy = ty - sy;

    return "U".repeat(dy)
        + "R".repeat(dx)
        + "D".repeat(dy)
        + "L".repeat(dx + 1)
        + "U".repeat(dy + 1)
        + "R".repeat(dx + 1)
        + "DR"
        + "D".repeat(dy + 1)
        + "L".repeat(dx + 1)
        + "U";
  }
}