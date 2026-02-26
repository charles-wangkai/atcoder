import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] a = new int[N];
    int[] b = new int[N];
    for (int i = 0; i < N; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }
    int[] c = new int[M];
    int[] d = new int[M];
    for (int i = 0; i < M; ++i) {
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, c, d));

    sc.close();
  }

  static String solve(int[] a, int[] b, int[] c, int[] d) {
    return IntStream.range(0, a.length)
        .map(
            i ->
                IntStream.range(0, c.length)
                        .boxed()
                        .min(
                            Comparator.<Integer, Integer>comparing(
                                    j -> Math.abs(c[j] - a[i]) + Math.abs(d[j] - b[i]))
                                .thenComparing(j -> j))
                        .get()
                    + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}