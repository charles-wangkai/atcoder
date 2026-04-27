import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int[] A, int[] B) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < A.length; ++i) {
      for (int j = 0; j < B.length; ++j) {
        result = Math.min(result, (j == i) ? (A[i] + B[j]) : Math.max(A[i], B[j]));
      }
    }

    return result;
  }
}