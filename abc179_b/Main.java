import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] D = new int[N][2];
    for (int i = 0; i < D.length; ++i) {
      for (int j = 0; j < D[i].length; ++j) {
        D[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(D) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[][] D) {
    return IntStream.range(0, D.length - 2)
        .anyMatch(
            i -> D[i][0] == D[i][1] && D[i + 1][0] == D[i + 1][1] && D[i + 2][0] == D[i + 2][1]);
  }
}