import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int x = sc.nextInt();

    System.out.printf("%.9f\n", solve(a, b, x));

    sc.close();
  }

  static double solve(int a, int b, int x) {
    return (2 * x <= a * a * b)
        ? Math.toDegrees(Math.atan2(b, 2.0 * x / (a * b)))
        : Math.toDegrees(Math.atan2(2 * (b - (double) x / (a * a)), a));
  }
}