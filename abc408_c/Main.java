import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] L = new int[M];
    int[] R = new int[M];
    for (int i = 0; i < M; ++i) {
      L[i] = sc.nextInt();
      R[i] = sc.nextInt();
    }

    System.out.println(solve(N, L, R));

    sc.close();
  }

  static int solve(int N, int[] L, int[] R) {
    int[] deltas = new int[N];
    for (int i = 0; i < L.length; ++i) {
      ++deltas[L[i] - 1];

      if (R[i] != N) {
        --deltas[R[i]];
      }
    }

    int result = Integer.MAX_VALUE;
    int count = 0;
    for (int delta : deltas) {
      count += delta;
      result = Math.min(result, count);
    }

    return result;
  }
}