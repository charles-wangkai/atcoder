import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] C = new int[N - 1][];
    for (int i = 0; i < C.length; ++i) {
      C[i] = new int[N - i - 1];
      for (int j = 0; j < C[i].length; ++j) {
        C[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(C) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[][] C) {
    int N = C.length + 1;

    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        for (int k = j + 1; k < N; ++k) {
          if (C[i][j - i - 1] + C[j][k - j - 1] < C[i][k - i - 1]) {
            return true;
          }
        }
      }
    }

    return false;
  }
}