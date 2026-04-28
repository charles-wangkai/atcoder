import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] A = new int[N][];
    for (int i = 0; i < A.length; ++i) {
      A[i] = new int[i + 1];
      for (int j = 0; j < A[i].length; ++j) {
        A[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[][] A) {
    int N = A.length;

    int result = 1;
    for (int i = 1; i <= N; ++i) {
      result = (result >= i) ? A[result - 1][i - 1] : A[i - 1][result - 1];
    }

    return result;
  }
}