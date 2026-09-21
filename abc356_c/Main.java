import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();
    int[][] A = new int[M][];
    char[] R = new char[M];
    for (int i = 0; i < M; ++i) {
      int C = sc.nextInt();
      A[i] = new int[C];
      for (int j = 0; j < A[i].length; ++j) {
        A[i][j] = sc.nextInt();
      }
      R[i] = sc.next().charAt(0);
    }

    System.out.println(solve(N, A, R, K));

    sc.close();
  }

  static int solve(int N, int[][] A, char[] R, int K) {
    return (int)
        IntStream.range(0, 1 << N)
            .filter(
                mask ->
                    IntStream.range(0, A.length)
                        .allMatch(
                            i ->
                                (Arrays.stream(A[i])
                                            .filter(Ai -> ((mask >> (Ai - 1)) & 1) == 1)
                                            .count()
                                        >= K)
                                    == (R[i] == 'o')))
            .count();
  }
}