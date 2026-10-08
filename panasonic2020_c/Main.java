import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();

    System.out.println(solve(a, b, c) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int a, int b, int c) {
    return c - a - b >= 0 && 4L * a * b < (long) (c - a - b) * (c - a - b);
  }
}