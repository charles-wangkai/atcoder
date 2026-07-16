import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] a = new int[N - 1];
    int[] b = new int[N - 1];
    for (int i = 0; i < N - 1; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }
    int[] p = new int[Q];
    int[] x = new int[Q];
    for (int i = 0; i < Q; ++i) {
      p[i] = sc.nextInt();
      x[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, p, x));

    sc.close();
  }

  static String solve(int[] a, int[] b, int[] p, int[] x) {
    int N = a.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[N];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < a.length; ++i) {
      adjLists[a[i] - 1].add(b[i] - 1);
      adjLists[b[i] - 1].add(a[i] - 1);
    }

    int[] deltas = new int[N];
    for (int i = 0; i < p.length; ++i) {
      deltas[p[i] - 1] += x[i];
    }

    int[] counters = new int[N];
    search(counters, adjLists, deltas, 0, -1, 0);

    return Arrays.stream(counters).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static void search(
      int[] counters, List<Integer>[] adjLists, int[] deltas, int sum, int parent, int node) {
    sum += deltas[node];
    counters[node] = sum;

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search(counters, adjLists, deltas, sum, node, adj);
      }
    }
  }
}