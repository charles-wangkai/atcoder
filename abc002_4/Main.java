import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[] x = new int[M];
      int[] y = new int[M];
      for (int i = 0; i < M; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(N, x, y));
    }
  }

  static int solve(int N, int[] x, int[] y) {
    Set<Edge> edges =
        IntStream.range(0, x.length)
            .mapToObj(i -> new Edge(x[i] - 1, y[i] - 1))
            .collect(Collectors.toSet());

    return IntStream.range(0, 1 << N)
        .filter(mask ->
            check(edges, IntStream.range(0, N).filter(i -> ((mask >> i) & 1) == 1).toArray()))
        .map(Integer::bitCount)
        .max()
        .getAsInt();
  }

  static boolean check(Set<Edge> edges, int[] nodes) {
    for (int i = 0; i < nodes.length; ++i) {
      for (int j = i + 1; j < nodes.length; ++j) {
        if (!edges.contains(new Edge(nodes[i], nodes[j]))) {
          return false;
        }
      }
    }

    return true;
  }
}

record Edge(int node1, int node2) {}
