import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] C = new int[N];
    int[] P = new int[N];
    for (int i = 0; i < N; ++i) {
      C[i] = sc.nextInt();
      P[i] = sc.nextInt();
    }
    int Q = sc.nextInt();
    int[] L = new int[Q];
    int[] R = new int[Q];
    for (int i = 0; i < Q; ++i) {
      L[i] = sc.nextInt();
      R[i] = sc.nextInt();
    }

    System.out.println(solve(C, P, L, R));

    sc.close();
  }

  static String solve(int[] C, int[] P, int[] L, int[] R) {
    int N = C.length;

    int[][] prefixSums = new int[N + 1][2];
    for (int i = 1; i < prefixSums.length; ++i) {
      for (int j = 0; j < 2; ++j) {
        prefixSums[i][j] = prefixSums[i - 1][j];
      }

      prefixSums[i][C[i - 1] - 1] += P[i - 1];
    }

    return IntStream.range(0, L.length)
        .mapToObj(
            i ->
                IntStream.range(0, 2)
                    .map(j -> prefixSums[R[i]][j] - prefixSums[L[i] - 1][j])
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}