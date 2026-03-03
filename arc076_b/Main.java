import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] x = new int[N];
    int[] y = new int[N];
    for (int i = 0; i < N; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y));

    sc.close();
  }

  static int solve(int[] x, int[] y) {
    List<Edge> edges = new ArrayList<>();

    int[] xSortedIndices =
        IntStream.range(0, x.length)
            .boxed()
            .sorted(Comparator.comparing(i -> x[i]))
            .mapToInt(Integer::intValue)
            .toArray();
    for (int i = 0; i < xSortedIndices.length - 1; ++i) {
      int v1 = xSortedIndices[i];
      int v2 = xSortedIndices[i + 1];

      edges.add(new Edge(v1, v2, x[v2] - x[v1]));
    }

    int[] ySortedIndices =
        IntStream.range(0, x.length)
            .boxed()
            .sorted(Comparator.comparing(i -> y[i]))
            .mapToInt(Integer::intValue)
            .toArray();
    for (int i = 0; i < ySortedIndices.length - 1; ++i) {
      int v1 = ySortedIndices[i];
      int v2 = ySortedIndices[i + 1];

      edges.add(new Edge(v1, v2, y[v2] - y[v1]));
    }

    Collections.sort(edges, Comparator.comparing(Edge::distance));

    int result = 0;
    Dsu dsu = new Dsu(x.length);
    for (Edge edge : edges) {
      int leader1 = dsu.find(edge.v1());
      int leader2 = dsu.find(edge.v2());
      if (leader1 != leader2) {
        result += edge.distance();
        dsu.union(leader1, leader2);
      }
    }

    return result;
  }
}

record Edge(int v1, int v2, int distance) {}

class Dsu {
  int[] parentOrSizes;

  Dsu(int n) {
    parentOrSizes = new int[n];
    Arrays.fill(parentOrSizes, -1);
  }

  int find(int a) {
    if (parentOrSizes[a] < 0) {
      return a;
    }

    parentOrSizes[a] = find(parentOrSizes[a]);

    return parentOrSizes[a];
  }

  void union(int a, int b) {
    int aLeader = find(a);
    int bLeader = find(b);
    if (aLeader != bLeader) {
      parentOrSizes[aLeader] += parentOrSizes[bLeader];
      parentOrSizes[bLeader] = aLeader;
    }
  }

  int getSize(int a) {
    return -parentOrSizes[find(a)];
  }

  Map<Integer, List<Integer>> buildLeaderToGroup() {
    Map<Integer, List<Integer>> leaderToGroup = new HashMap<>();
    for (int i = 0; i < parentOrSizes.length; ++i) {
      int leader = find(i);
      leaderToGroup.putIfAbsent(leader, new ArrayList<>());
      leaderToGroup.get(leader).add(i);
    }

    return leaderToGroup;
  }
}
