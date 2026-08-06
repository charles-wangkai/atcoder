import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    int e = sc.nextInt();
    int f = sc.nextInt();
    int g = sc.nextInt();
    int h = sc.nextInt();
    int i = sc.nextInt();
    int j = sc.nextInt();
    int k = sc.nextInt();
    int l = sc.nextInt();

    System.out.println(solve(a, b, c, d, e, f, g, h, i, j, k, l) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(
      int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l) {
    return isIntersect(a, d, g, j) && isIntersect(b, e, h, k) && isIntersect(c, f, i, l);
  }

  static boolean isIntersect(int min1, int max1, int min2, int max2) {
    return Math.max(min1, min2) < Math.min(max1, max2);
  }
}