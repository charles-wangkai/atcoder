import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int M = sc.nextInt();
    int[] a = new int[A];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[B];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }
    int[] x = new int[M];
    int[] y = new int[M];
    int[] c = new int[M];
    for (int i = 0; i < M; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, x, y, c));

    sc.close();
  }

  static int solve(int[] a, int[] b, int[] x, int[] y, int[] c) {
    return Math.min(
        Arrays.stream(a).min().getAsInt() + Arrays.stream(b).min().getAsInt(),
        IntStream.range(0, x.length).map(i -> a[x[i] - 1] + b[y[i] - 1] - c[i]).min().getAsInt());
  }
}