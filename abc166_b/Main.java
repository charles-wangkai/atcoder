import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[][] A = new int[K][];
    for (int i = 0; i < A.length; ++i) {
      int d = sc.nextInt();
      A[i] = new int[d];
      for (int j = 0; j < A[i].length; ++j) {
        A[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(N, A));

    sc.close();
  }

  static int solve(int N, int[][] A) {
    return N - (int) Arrays.stream(A).flatMapToInt(Arrays::stream).distinct().count();
  }
}