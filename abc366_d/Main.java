import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[][][] A = new int[N][N][N];
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          for (int k = 0; k < N; ++k) {
            A[i][j][k] = sc.nextInt();
          }
        }
      }
      int Q = sc.nextInt();
      int[] Lx = new int[Q];
      int[] Rx = new int[Q];
      int[] Ly = new int[Q];
      int[] Ry = new int[Q];
      int[] Lz = new int[Q];
      int[] Rz = new int[Q];
      for (int i = 0; i < Q; ++i) {
        Lx[i] = sc.nextInt();
        Rx[i] = sc.nextInt();
        Ly[i] = sc.nextInt();
        Ry[i] = sc.nextInt();
        Lz[i] = sc.nextInt();
        Rz[i] = sc.nextInt();
      }

      System.out.println(solve(A, Lx, Rx, Ly, Ry, Lz, Rz));
    }
  }

  static String solve(int[][][] A, int[] Lx, int[] Rx, int[] Ly, int[] Ry, int[] Lz, int[] Rz) {
    int N = A.length;

    int[][][] prefixSums = new int[N + 1][N + 1][N + 1];
    for (int i = 1; i <= N; ++i) {
      for (int j = 1; j <= N; ++j) {
        for (int k = 1; k <= N; ++k) {
          prefixSums[i][j][k] =
              prefixSums[i - 1][j][k]
                  + prefixSums[i][j - 1][k]
                  + prefixSums[i][j][k - 1]
                  - prefixSums[i - 1][j - 1][k]
                  - prefixSums[i][j - 1][k - 1]
                  - prefixSums[i - 1][j][k - 1]
                  + prefixSums[i - 1][j - 1][k - 1]
                  + A[i - 1][j - 1][k - 1];
        }
      }
    }

    return IntStream.range(0, Lx.length)
        .map(i ->
            prefixSums[Rx[i]][Ry[i]][Rz[i]]
                - prefixSums[Lx[i] - 1][Ry[i]][Rz[i]]
                - prefixSums[Rx[i]][Ly[i] - 1][Rz[i]]
                - prefixSums[Rx[i]][Ry[i]][Lz[i] - 1]
                + prefixSums[Lx[i] - 1][Ly[i] - 1][Rz[i]]
                + prefixSums[Rx[i]][Ly[i] - 1][Lz[i] - 1]
                + prefixSums[Lx[i] - 1][Ry[i]][Lz[i] - 1]
                - prefixSums[Lx[i] - 1][Ly[i] - 1][Lz[i] - 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}