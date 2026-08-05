import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] q = new int[N];
    int[] r = new int[N];
    for (int i = 0; i < N; ++i) {
      q[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }
    int Q = sc.nextInt();
    int[] t = new int[Q];
    int[] d = new int[Q];
    for (int i = 0; i < Q; ++i) {
      t[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    System.out.println(solve(q, r, t, d));

    sc.close();
  }

  static String solve(int[] q, int[] r, int[] t, int[] d) {
    return IntStream.range(0, t.length)
        .map(i -> d[i] + Math.floorMod(r[t[i] - 1] - d[i], q[t[i] - 1]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}