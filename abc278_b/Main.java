import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(solve(H, M));

    sc.close();
  }

  static String solve(int H, int M) {
    int h = H;
    int m = M;
    while (!isConfusing(h, m)) {
      m = (m + 1) % 60;
      if (m == 0) {
        h = (h + 1) % 24;
      }
    }

    return "%d %d".formatted(h, m);
  }

  static boolean isConfusing(int h, int m) {
    int h1 = h / 10;
    int h2 = h % 10;
    int m1 = m / 10;
    int m2 = m % 10;

    return h1 * 10 + m1 <= 23 && h2 * 10 + m2 <= 59;
  }
}