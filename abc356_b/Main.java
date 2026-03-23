import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[][] X = new int[N][M];
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < M; ++j) {
        X[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(X, A) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[][] X, int[] A) {
    return IntStream.range(0, A.length)
        .allMatch(j -> IntStream.range(0, X.length).map(i -> X[i][j]).sum() >= A[j]);
  }
}