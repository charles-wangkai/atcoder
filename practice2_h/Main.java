import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int D = sc.nextInt();
    int[] X = new int[N];
    int[] Y = new int[N];
    for (int i = 0; i < N; ++i) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }

    System.out.println(solve(X, Y, D));

    sc.close();
  }

  static String solve(int[] X, int[] Y, int D) {
    int N = X.length;

    TwoSat twoSat = new TwoSat(N);
    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        if (Math.abs(X[i] - X[j]) < D) {
          twoSat.addClause(i, true, j, true);
        }
        if (Math.abs(X[i] - Y[j]) < D) {
          twoSat.addClause(i, true, j, false);
        }
        if (Math.abs(Y[i] - X[j]) < D) {
          twoSat.addClause(i, false, j, true);
        }
        if (Math.abs(Y[i] - Y[j]) < D) {
          twoSat.addClause(i, false, j, false);
        }
      }
    }

    boolean[] assignment = twoSat.findAssignment();
    if (assignment == null) {
      return "No";
    }

    return "Yes\n%s"
        .formatted(
            IntStream.range(0, assignment.length)
                .map(i -> assignment[i] ? Y[i] : X[i])
                .mapToObj(String::valueOf)
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

class TwoSat {
  int n;
  Scc scc;

  TwoSat(int n) {
    this.n = n;
    scc = new Scc(2 * n);
  }

  void addClause(int i, boolean f, int j, boolean g) {
    scc.addEdge(2 * i + (f ? 0 : 1), 2 * j + (g ? 1 : 0));
    scc.addEdge(2 * j + (g ? 0 : 1), 2 * i + (f ? 1 : 0));
  }

  boolean[] findAssignment() {
    int[] components = scc.buildComponents();

    boolean[] assignment = new boolean[n];
    for (int i = 0; i < assignment.length; ++i) {
      if (components[2 * i] == components[2 * i + 1]) {
        return null;
      }

      assignment[i] = components[2 * i] < components[2 * i + 1];
    }

    return assignment;
  }
}
