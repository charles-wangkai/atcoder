import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] x = new int[N][];
    int[][] y = new int[N][];
    for (int i = 0; i < N; ++i) {
      int A = sc.nextInt();
      x[i] = new int[A];
      y[i] = new int[A];
      for (int j = 0; j < A; ++j) {
        x[i][j] = sc.nextInt();
        y[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(x, y));

    sc.close();
  }

  static int solve(int[][] x, int[][] y) {
    int N = x.length;

    return IntStream.range(0, 1 << N)
        .filter(
            mask ->
                IntStream.range(0, N)
                    .allMatch(
                        i ->
                            ((mask >> i) & 1) == 0
                                || IntStream.range(0, x[i].length)
                                    .allMatch(j -> ((mask >> (x[i][j] - 1)) & 1) == y[i][j])))
        .map(Integer::bitCount)
        .max()
        .getAsInt();
  }
}