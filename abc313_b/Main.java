import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    int[] B = new int[M];
    for (int i = 0; i < M; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(N, A, B));

    sc.close();
  }

  static int solve(int N, int[] A, int[] B) {
    boolean[][] superiors = new boolean[N][N];
    for (int i = 0; i < A.length; ++i) {
      superiors[A[i] - 1][B[i] - 1] = true;
    }

    for (int k = 0; k < N; ++k) {
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          superiors[i][j] |= superiors[i][k] && superiors[k][j];
        }
      }
    }

    return IntStream.range(0, N)
        .filter(i -> IntStream.range(0, N).allMatch(j -> j == i || superiors[i][j]))
        .map(i -> i + 1)
        .findAny()
        .orElse(-1);
  }
}