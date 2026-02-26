import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N - 1];
    int[] b = new int[N - 1];
    int[] c = new int[N - 1];
    for (int i = 0; i < N - 1; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }
    int Q = sc.nextInt();
    int K = sc.nextInt();
    int[] x = new int[Q];
    int[] y = new int[Q];
    for (int i = 0; i < Q; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, c, x, y, K));

    sc.close();
  }

  static String solve(int[] a, int[] b, int[] c, int[] x, int[] y, int K) {
    int N = a.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[N];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < a.length; ++i) {
      edgeLists[a[i] - 1].add(i);
      edgeLists[b[i] - 1].add(i);
    }

    long[] distances = new long[N];
    search(distances, edgeLists, a, b, c, -1, K - 1, 0);

    return IntStream.range(0, x.length)
        .mapToLong(i -> distances[x[i] - 1] + distances[y[i] - 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static void search(
      long[] distances,
      List<Integer>[] edgeLists,
      int[] a,
      int[] b,
      int[] c,
      int parent,
      int node,
      long distance) {
    distances[node] = distance;

    for (int edge : edgeLists[node]) {
      int adj = (a[edge] - 1 == node) ? (b[edge] - 1) : (a[edge] - 1);
      if (adj != parent) {
        search(distances, edgeLists, a, b, c, node, adj, distance + c[edge]);
      }
    }
  }
}