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
    int K = sc.nextInt();
    int[] C = new int[K];
    int[] D = new int[K];
    for (int i = 0; i < K; ++i) {
      C[i] = sc.nextInt();
      D[i] = sc.nextInt();
    }

    System.out.println(solve(N, A, B, C, D));

    sc.close();
  }

  static int solve(int N, int[] A, int[] B, int[] C, int[] D) {
    int K = C.length;

    return IntStream.range(0, 1 << K)
        .map(
            mask -> {
              int[] counts = new int[N];
              for (int i = 0; i < K; ++i) {
                ++counts[((((mask >> i) & 1) == 1) ? C[i] : D[i]) - 1];
              }

              return (int)
                  IntStream.range(0, A.length)
                      .filter(i -> counts[A[i] - 1] > 0 && counts[B[i] - 1] > 0)
                      .count();
            })
        .max()
        .getAsInt();
  }
}