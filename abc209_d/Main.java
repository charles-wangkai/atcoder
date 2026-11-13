import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    int[] c = new int[Q];
    int[] d = new int[Q];
    for (int i = 0; i < Q; ++i) {
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, c, d));

    sc.close();
  }

  static String solve(int[] a, int[] b, int[] c, int[] d) {
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

    boolean[] colors = new boolean[N];
    search(colors, adjLists, true, -1, 0);

    return IntStream.range(0, c.length)
        .mapToObj(i -> (colors[c[i] - 1] == colors[d[i] - 1]) ? "Town" : "Road")
        .collect(Collectors.joining("\n"));
  }

  static void search(
      boolean[] colors, List<Integer>[] adjLists, boolean color, int parent, int node) {
    colors[node] = color;

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search(colors, adjLists, !color, node, adj);
      }
    }
  }
}