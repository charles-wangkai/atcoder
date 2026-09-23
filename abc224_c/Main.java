import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] X = new int[N];
    int[] Y = new int[N];
    for (int i = 0; i < N; ++i) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }

    System.out.println(solve(X, Y));

    sc.close();
  }

  static int solve(int[] X, int[] Y) {
    int N = X.length;

    int result = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        for (int k = j + 1; k < N; ++k) {
          if (isTriangle(X[i], Y[i], X[j], Y[j], X[k], Y[k])) {
            ++result;
          }
        }
      }
    }

    return result;
  }

  static boolean isTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
    int dx1 = x2 - x1;
    int dy1 = y2 - y1;

    int dx2 = x3 - x1;
    int dy2 = y3 - y1;

    return (long) dy1 * dx2 != (long) dy2 * dx1;
  }
}