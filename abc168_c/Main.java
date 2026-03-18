import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int H = sc.nextInt();
    int M = sc.nextInt();

    System.out.println("%.9f".formatted(solve(A, B, H, M)));

    sc.close();
  }

  static double solve(int A, int B, int H, int M) {
    return computeDistance(
        rotate(new Point(0, A), Math.toRadians(H / 12.0 * 360 + M / 60.0 * 30)),
        rotate(new Point(0, B), Math.toRadians(M / 60.0 * 360)));
  }

  static Point rotate(Point p, double angle) {
    return new Point(
        p.x() * Math.cos(angle) + p.y() * Math.sin(angle),
        -p.x() * Math.sin(angle) + p.y() * Math.cos(angle));
  }

  static double computeDistance(Point p1, Point p2) {
    return Math.sqrt((p1.x() - p2.x()) * (p1.x() - p2.x()) + (p1.y() - p2.y()) * (p1.y() - p2.y()));
  }
}

record Point(double x, double y) {}
