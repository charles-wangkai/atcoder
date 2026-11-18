import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();

      System.out.println(solve(N));
    }
  }

  static int solve(int N) {
    int[][] counts = new int[10][10];
    for (int i = 1; i <= N; ++i) {
      String s = String.valueOf(i);
      ++counts[s.charAt(0) - '0'][s.charAt(s.length() - 1) - '0'];
    }

    int result = 0;
    for (int i = 1; i <= 9; ++i) {
      for (int j = 1; j <= 9; ++j) {
        result += counts[i][j] * counts[j][i];
      }
    }

    return result;
  }
}