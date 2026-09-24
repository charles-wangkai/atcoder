import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long X = sc.nextLong();
    int[][] a = new int[N][];
    for (int i = 0; i < a.length; ++i) {
      int L = sc.nextInt();
      a[i] = new int[L];
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(a, X));

    sc.close();
  }

  static int solve(int[][] a, long X) {
    return search(a, X, 0);
  }

  static int search(int[][] a, long X, int depth) {
    if (depth == a.length) {
      return (X == 1) ? 1 : 0;
    }

    int result = 0;
    for (int value : a[depth]) {
      if (X % value == 0) {
        result += search(a, X / value, depth + 1);
      }
    }

    return result;
  }
}