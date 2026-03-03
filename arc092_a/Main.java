import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N];
    int[] b = new int[N];
    for (int i = 0; i < N; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }
    int[] c = new int[N];
    int[] d = new int[N];
    for (int i = 0; i < N; ++i) {
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, c, d));

    sc.close();
  }

  static int solve(int[] a, int[] b, int[] c, int[] d) {
    int N = a.length;

    MaxFlow maxFlow = new MaxFlow(2 * N + 2);
    int source = 0;
    int sink = 2 * N + 1;
    for (int i = 0; i < N; ++i) {
      maxFlow.addEdges(source, i + 1, 1);
    }
    for (int i = 0; i < N; ++i) {
      maxFlow.addEdges(N + 1 + i, sink, 1);
    }
    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        if (a[i] < c[j] && b[i] < d[j]) {
          maxFlow.addEdges(i + 1, N + 1 + j, 1);
        }
      }
    }

    return maxFlow.dinic(source, sink);
  }
}

class MaxFlow {
  List<Edge> edges = new ArrayList<>();
  List<Integer>[] edgeLists;

  @SuppressWarnings("unchecked")
  MaxFlow(int size) {
    edgeLists = new List[size];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
  }

  void addEdges(int u, int v, int cap) {
    edges.add(new Edge(u, v, cap));
    edgeLists[u].add(edges.size() - 1);

    edges.add(new Edge(v, u, 0));
    edgeLists[v].add(edges.size() - 1);
  }

  int dinic(int s, int t) {
    int result = 0;
    while (true) {
      int[] levels = bfs(s, t);
      if (levels == null) {
        break;
      }

      while (true) {
        int minflow = dfs(levels, s, t, Integer.MAX_VALUE);
        if (minflow == 0) {
          break;
        }

        result += minflow;
      }
    }

    return result;
  }

  private int[] bfs(int s, int t) {
    int[] levels = new int[edgeLists.length];
    Arrays.fill(levels, -1);
    levels[s] = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(s);

    while (!queue.isEmpty()) {
      int head = queue.poll();
      if (head == t) {
        return levels;
      }

      for (int e : edgeLists[head]) {
        Edge edge = edges.get(e);
        if (edge.capacity != 0 && levels[edge.to] == -1) {
          levels[edge.to] = levels[head] + 1;
          queue.offer(edge.to);
        }
      }
    }

    return null;
  }

  private int dfs(int[] levels, int s, int t, int low) {
    if (s == t) {
      return low;
    }

    int result = 0;
    for (int e : edgeLists[s]) {
      Edge edge = edges.get(e);
      if (edge.capacity != 0 && levels[edge.to] == levels[s] + 1) {
        int next = dfs(levels, edge.to, t, Math.min(low - result, edge.capacity));
        edge.capacity -= next;
        edges.get(e ^ 1).capacity += next;

        result += next;
        if (result == low) {
          break;
        }
      }
    }

    if (result == 0) {
      levels[s] = -1;
    }

    return result;
  }

  static class Edge {
    int from;
    int to;
    int capacity;

    Edge(int from, int to, int capacity) {
      this.from = from;
      this.to = to;
      this.capacity = capacity;
    }
  }
}
