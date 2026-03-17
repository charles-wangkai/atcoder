import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();

    System.out.println(solve(a, b, c, d));

    sc.close();
  }

  static int solve(int a, int b, int c, int d) {
    int result = Integer.MIN_VALUE;
    for (int x = a; x <= b; ++x) {
      for (int y = c; y <= d; ++y) {
        result = Math.max(result, x - y);
      }
    }

    return result;
  }
}