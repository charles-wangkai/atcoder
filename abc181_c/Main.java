import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] x = new int[N];
    int[] y = new int[N];
    for (int i = 0; i < N; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] x, int[] y) {
    int N = x.length;

    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        for (int k = j + 1; k < N; ++k) {
          if (isCollinear(x[i], y[i], x[j], y[j], x[k], y[k])) {
            return true;
          }
        }
      }
    }

    return false;
  }

  static boolean isCollinear(int x1, int y1, int x2, int y2, int x3, int y3) {
    return (x2 - x1) * (y3 - y1) == (y2 - y1) * (x3 - x1);
  }
}