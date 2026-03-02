import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] a = new int[N - 1];
    int[] b = new int[N - 1];
    int[] c = new int[N - 1];
    int[] d = new int[N - 1];
    for (int i = 0; i < N - 1; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }
    int[] x = new int[Q];
    int[] y = new int[Q];
    int[] u = new int[Q];
    int[] v = new int[Q];
    for (int i = 0; i < Q; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, c, d, x, y, u, v));

    sc.close();
  }

  static String solve(int[] a, int[] b, int[] c, int[] d, int[] x, int[] y, int[] u, int[] v) {
    int Q = x.length;

    Tree tree =
        new Tree(
            Arrays.stream(a).map(ai -> ai - 1).toArray(),
            Arrays.stream(b).map(bi -> bi - 1).toArray(),
            c,
            d);

    int[] lcas = IntStream.range(0, Q).map(i -> tree.findLca(u[i] - 1, v[i] - 1)).toArray();

    Map<Integer, Set<Integer>> nodeToQueryIndices = new HashMap<>();
    for (int i = 0; i < Q; ++i) {
      for (int node : new int[] {u[i] - 1, v[i] - 1, lcas[i]}) {
        nodeToQueryIndices.putIfAbsent(node, new HashSet<>());
        nodeToQueryIndices.get(node).add(i);
      }
    }

    int[] queryResults = new int[Q];
    tree.search(
        queryResults, x, y, u, v, lcas, nodeToQueryIndices, 0, new HashMap<>(), new HashMap<>(), 0);

    return Arrays.stream(queryResults).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class Tree {
  int n;
  int[] u;
  int[] v;
  int[] c;
  int[] d;
  List<Integer>[] edgeLists;
  int[] depths;
  int[][] ancestors;

  @SuppressWarnings("unchecked")
  Tree(int[] u, int[] v, int[] c, int[] d) {
    n = u.length + 1;

    this.u = u;
    this.v = v;
    this.c = c;
    this.d = d;

    edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      edgeLists[u[i]].add(i);
      edgeLists[v[i]].add(i);
    }

    depths = new int[n];
    ancestors = new int[n][Integer.toBinaryString(n).length()];
    buildDepthsAndAncestors(0, -1, 0);
  }

  private void buildDepthsAndAncestors(int depth, int parent, int node) {
    depths[node] = depth;

    ancestors[node][0] = parent;
    for (int i = 1; i < ancestors[node].length; ++i) {
      ancestors[node][i] =
          (ancestors[node][i - 1] == -1) ? -1 : ancestors[ancestors[node][i - 1]][i - 1];
    }

    for (int edge : edgeLists[node]) {
      int adj = (node == u[edge]) ? v[edge] : u[edge];
      if (adj != parent) {
        buildDepthsAndAncestors(depth + 1, node, adj);
      }
    }
  }

  int findLca(int node1, int node2) {
    if (depths[node1] < depths[node2]) {
      return findLca(node2, node1);
    }

    for (int i = ancestors[node1].length - 1; i >= 0; --i) {
      if (ancestors[node1][i] != -1 && depths[ancestors[node1][i]] >= depths[node2]) {
        node1 = ancestors[node1][i];
      }
    }

    if (node1 == node2) {
      return node1;
    }

    for (int i = ancestors[node1].length - 1; i >= 0; --i) {
      if (ancestors[node1][i] != ancestors[node2][i]) {
        node1 = ancestors[node1][i];
        node2 = ancestors[node2][i];
      }
    }

    return ancestors[node1][0];
  }

  void search(
      int[] queryResults,
      int[] x,
      int[] y,
      int[] node1s,
      int[] node2s,
      int[] lcas,
      Map<Integer, Set<Integer>> nodeToQueryIndices,
      int distance,
      Map<Integer, Integer> colorToCount,
      Map<Integer, Integer> colorToDistance,
      int node) {
    for (int queryIndex : nodeToQueryIndices.getOrDefault(node, Set.of())) {
      int delta =
          distance
              - colorToDistance.getOrDefault(x[queryIndex], 0)
              + colorToCount.getOrDefault(x[queryIndex], 0) * y[queryIndex];

      if (node1s[queryIndex] - 1 == node) {
        queryResults[queryIndex] += delta;
      }
      if (node2s[queryIndex] - 1 == node) {
        queryResults[queryIndex] += delta;
      }
      if (lcas[queryIndex] == node) {
        queryResults[queryIndex] -= delta * 2;
      }
    }

    for (int edge : edgeLists[node]) {
      int adj = (node == u[edge]) ? v[edge] : u[edge];
      if (depths[adj] == depths[node] + 1) {
        colorToCount.put(c[edge], colorToCount.getOrDefault(c[edge], 0) + 1);
        colorToDistance.put(c[edge], colorToDistance.getOrDefault(c[edge], 0) + d[edge]);

        search(
            queryResults,
            x,
            y,
            node1s,
            node2s,
            lcas,
            nodeToQueryIndices,
            distance + d[edge],
            colorToCount,
            colorToDistance,
            adj);

        colorToCount.put(c[edge], colorToCount.get(c[edge]) - 1);
        colorToDistance.put(c[edge], colorToDistance.get(c[edge]) - d[edge]);
      }
    }
  }
}
