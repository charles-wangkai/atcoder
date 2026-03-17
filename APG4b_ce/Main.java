import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
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

  static String solve(int N, int[] A, int[] B) {
    char[][] result = new char[N][N];
    for (int i = 0; i < result.length; ++i) {
      Arrays.fill(result[i], '-');
    }
    for (int i = 0; i < A.length; ++i) {
      result[A[i] - 1][B[i] - 1] = 'o';
      result[B[i] - 1][A[i] - 1] = 'x';
    }

    return Arrays.stream(result)
        .map(
            line ->
                IntStream.range(0, line.length)
                    .mapToObj(i -> line[i])
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}