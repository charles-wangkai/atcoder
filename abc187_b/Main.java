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

    System.out.println(solve(x, y));

    sc.close();
  }

  static int solve(int[] x, int[] y) {
    int result = 0;
    for (int i = 0; i < x.length; ++i) {
      for (int j = i + 1; j < x.length; ++j) {
        if (Math.abs(y[i] - y[j]) <= Math.abs(x[i] - x[j])) {
          ++result;
        }
      }
    }

    return result;
  }
}