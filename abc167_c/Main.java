import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int X = sc.nextInt();
    int[] C = new int[N];
    int[][] A = new int[N][M];
    for (int i = 0; i < N; ++i) {
      C[i] = sc.nextInt();
      for (int j = 0; j < M; ++j) {
        A[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(A, C, X));

    sc.close();
  }

  static int solve(int[][] A, int[] C, int X) {
    int N = A.length;
    int M = A[0].length;

    return IntStream.range(0, 1 << N)
        .filter(
            mask ->
                IntStream.range(0, M)
                    .allMatch(
                        j ->
                            IntStream.range(0, N)
                                    .filter(i -> ((mask >> i) & 1) == 1)
                                    .map(i -> A[i][j])
                                    .sum()
                                >= X))
        .map(mask -> IntStream.range(0, N).filter(i -> ((mask >> i) & 1) == 1).map(i -> C[i]).sum())
        .min()
        .orElse(-1);
  }
}