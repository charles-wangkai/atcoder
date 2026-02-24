import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] a = new int[M];
    int[] b = new int[M];
    for (int i = 0; i < M; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(N, a, b));

    sc.close();
  }

  static String solve(int N, int[] a, int[] b) {
    Scc scc = new Scc(N);
    for (int i = 0; i < a.length; ++i) {
      scc.addEdge(a[i], b[i]);
    }

    int[] components = scc.buildComponents();

    @SuppressWarnings("unchecked")
    List<Integer>[] componentLists = new List[Arrays.stream(components).max().getAsInt() + 1];
    for (int i = 0; i < componentLists.length; ++i) {
      componentLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < components.length; ++i) {
      componentLists[components[i]].add(i);
    }

    return "%d\n%s"
        .formatted(
            componentLists.length,
            Arrays.stream(componentLists)
                .map(
                    componentList ->
                        "%d %s"
                            .formatted(
                                componentList.size(),
                                componentList.stream()
                                    .map(String::valueOf)
                                    .collect(Collectors.joining(" "))))
                .collect(Collectors.joining("\n")));
  }
}

class Scc {
  List<Integer>[] adjLists;
  List<Integer>[] reversedAdjLists;

  @SuppressWarnings("unchecked")
  Scc(int n) {
    adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }

    reversedAdjLists = new List[n];
    for (int i = 0; i < reversedAdjLists.length; ++i) {
      reversedAdjLists[i] = new ArrayList<>();
    }
  }

  void addEdge(int from, int to) {
    adjLists[from].add(to);
    reversedAdjLists[to].add(from);
  }

  List<Integer> topologicalSort() {
    int n = adjLists.length;

    List<Integer> sorted = new ArrayList<>();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; ++i) {
      if (!visited[i]) {
        search1(sorted, visited, i);
      }
    }
    Collections.reverse(sorted);

    return sorted;
  }

  private void search1(List<Integer> sorted, boolean[] visited, int node) {
    visited[node] = true;

    for (int adj : adjLists[node]) {
      if (!visited[adj]) {
        search1(sorted, visited, adj);
      }
    }

    sorted.add(node);
  }

  int[] buildComponents() {
    int n = adjLists.length;

    List<Integer> sorted = topologicalSort();

    int[] components = new int[n];
    Arrays.fill(components, -1);
    int component = 0;
    for (int node : sorted) {
      if (components[node] == -1) {
        search2(components, component, node);
        ++component;
      }
    }

    return components;
  }

  private void search2(int[] components, int component, int node) {
    components[node] = component;

    for (int adj : reversedAdjLists[node]) {
      if (components[adj] == -1) {
        search2(components, component, adj);
      }
    }
  }
}
