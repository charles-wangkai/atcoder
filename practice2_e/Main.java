// https://atcoder.github.io/ac-library/master/document_en/mincostflow.html

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int VALUE_LIMIT = 1_000_000_000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[][] A = new int[N][N];
    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        A[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(A, K));

    sc.close();
  }

  static String solve(int[][] A, int K) {
    int N = A.length;

    int source = 0;
    int sink = 2 * N + 1;
    MinCostFlow minCostFlow = new MinCostFlow(2 * N + 2);

    minCostFlow.addEdges(source, sink, N * K, VALUE_LIMIT);

    for (int i = 0; i < N; ++i) {
      minCostFlow.addEdges(source, i + 1, K, 0);
      minCostFlow.addEdges(N + i + 1, sink, K, 0);
    }

    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        minCostFlow.addEdges(r + 1, N + c + 1, 1, VALUE_LIMIT - A[r][c]);
      }
    }

    long minCost = (long) N * K * VALUE_LIMIT - minCostFlow.computeMinCost(source, sink, N * K);

    char[][] t = new char[N][N];
    for (int r = 0; r < N; ++r) {
      Arrays.fill(t[r], '.');
    }
    for (int i = 0; i < minCostFlow.edges.size(); i += 2) {
      MinCostFlow.Edge edge = minCostFlow.edges.get(i);
      if (edge.from != source && edge.to != sink && edge.capacity == 0) {
        t[edge.from - 1][edge.to - N - 1] = 'X';
      }
    }

    return "%d\n%s"
        .formatted(
            minCost, Arrays.stream(t).map(String::valueOf).collect(Collectors.joining("\n")));
  }
}

class MinCostFlow {
  List<Edge> edges = new ArrayList<>();
  List<Integer>[] edgeLists;

  @SuppressWarnings("unchecked")
  MinCostFlow(int size) {
    edgeLists = new List[size];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
  }

  void addEdges(int u, int v, int cap, int cost) {
    edges.add(new Edge(u, v, cap, cost));
    edgeLists[u].add(edges.size() - 1);

    edges.add(new Edge(v, u, 0, -cost));
    edgeLists[v].add(edges.size() - 1);
  }

  long computeMinCost(int s, int t, int f) {
    int size = edgeLists.length;

    long result = 0;
    while (f != 0) {
      int[] prevEdges = new int[size];
      long[] distances = new long[size];
      Arrays.fill(distances, Long.MAX_VALUE);
      distances[s] = 0;
      while (true) {
        boolean updated = false;
        for (int v = 0; v < size; ++v) {
          if (distances[v] != Long.MAX_VALUE) {
            for (int e : edgeLists[v]) {
              Edge edge = edges.get(e);
              if (edge.capacity != 0 && distances[v] + edge.cost < distances[edge.to]) {
                distances[edge.to] = distances[v] + edge.cost;
                prevEdges[edge.to] = e;

                updated = true;
              }
            }
          }
        }

        if (!updated) {
          break;
        }
      }

      int d = f;
      for (int v = t; v != s; v = edges.get(prevEdges[v]).from) {
        d = Math.min(d, edges.get(prevEdges[v]).capacity);
      }
      f -= d;
      result += d * distances[t];

      for (int v = t; v != s; v = edges.get(prevEdges[v]).from) {
        Edge edge = edges.get(prevEdges[v]);

        edge.capacity -= d;
        edges.get(prevEdges[v] ^ 1).capacity += d;
      }
    }

    return result;
  }

  static class Edge {
    int from;
    int to;
    int capacity;
    int cost;

    Edge(int from, int to, int capacity, int cost) {
      this.from = from;
      this.to = to;
      this.capacity = capacity;
      this.cost = cost;
    }
  }
}
