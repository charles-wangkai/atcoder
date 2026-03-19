import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N - 1];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, K, M));

    sc.close();
  }

  static int solve(int[] A, int K, int M) {
    int N = A.length + 1;

    int needed = Math.max(0, M * N - Arrays.stream(A).sum());

    return (needed <= K) ? needed : -1;
  }
}