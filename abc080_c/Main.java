import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][][] F = new int[N][5][2];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < 5; ++j) {
        for (int k = 0; k < 2; ++k) {
          F[i][j][k] = sc.nextInt();
        }
      }
    }
    int[][] P = new int[N][11];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < 11; ++j) {
        P[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(F, P));

    sc.close();
  }

  static int solve(int[][][] F, int[][] P) {
    int N = F.length;

    return IntStream.range(1, 1 << 10)
        .map(
            mask ->
                IntStream.range(0, N)
                    .map(
                        i ->
                            P[i][
                                (int)
                                    IntStream.range(0, 10)
                                        .filter(
                                            j -> F[i][j / 2][j % 2] == 1 && ((mask >> j) & 1) == 1)
                                        .count()])
                    .sum())
        .max()
        .getAsInt();
  }
}