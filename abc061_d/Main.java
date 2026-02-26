import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] a = new int[M];
    int[] b = new int[M];
    int[] c = new int[M];
    for (int i = 0; i < M; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(N, a, b, c));

    sc.close();
  }

  static String solve(int N, int[] a, int[] b, int[] c) {
    long[] distances = new long[N];
    Arrays.fill(distances, Long.MIN_VALUE);
    distances[0] = 0;

    for (int round = 0; round < N - 1; ++round) {
      for (int i = 0; i < a.length; ++i) {
        if (distances[a[i] - 1] != Long.MIN_VALUE) {
          distances[b[i] - 1] = Math.max(distances[b[i] - 1], distances[a[i] - 1] + c[i]);
        }
      }
    }

    boolean[] infinites = new boolean[N];
    for (int i = 0; i < a.length; ++i) {
      if (distances[a[i] - 1] != Long.MIN_VALUE
          && distances[a[i] - 1] + c[i] > distances[b[i] - 1]) {
        infinites[b[i] - 1] = true;
      }
    }

    for (int round = 0; round < N - 1; ++round) {
      for (int i = 0; i < a.length; ++i) {
        if (infinites[a[i] - 1]) {
          infinites[b[i] - 1] = true;
        }
      }
    }

    return infinites[N - 1] ? "inf" : String.valueOf(distances[N - 1]);
  }
}