import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] R_OFFSETS = {0, -2, -2, -1, 1, 2, 2, 1, -1};
  static final int[] C_OFFSETS = {0, -1, 1, 2, 2, 1, -1, -2, -2};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] a = new int[M];
    int[] b = new int[M];
    for (int i = 0; i < M; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(N, a, b));

    sc.close();
  }

  static long solve(int N, int[] a, int[] b) {
    return (long) N * N
        - IntStream.range(0, a.length)
            .boxed()
            .flatMap(
                i ->
                    IntStream.range(0, R_OFFSETS.length)
                        .mapToObj(j -> new Point(a[i] - 1 + R_OFFSETS[j], b[i] - 1 + C_OFFSETS[j])))
            .filter(point -> point.r() >= 0 && point.r() < N && point.c() >= 0 && point.c() < N)
            .distinct()
            .count();
  }
}

record Point(int r, int c) {}
