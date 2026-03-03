import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int L = sc.nextInt();
    int[] p = new int[K];
    int[] q = new int[K];
    for (int i = 0; i < K; ++i) {
      p[i] = sc.nextInt();
      q[i] = sc.nextInt();
    }
    int[] r = new int[L];
    int[] s = new int[L];
    for (int i = 0; i < L; ++i) {
      r[i] = sc.nextInt();
      s[i] = sc.nextInt();
    }

    System.out.println(solve(N, p, q, r, s));

    sc.close();
  }

  static String solve(int N, int[] p, int[] q, int[] r, int[] s) {
    int[] roadLeaders = buildLeaders(N, p, q);
    int[] railwayLeaders = buildLeaders(N, r, s);

    Map<Element, Integer> elementToCount = new HashMap<>();
    for (int i = 0; i < N; ++i) {
      Element element = new Element(roadLeaders[i], railwayLeaders[i]);

      elementToCount.put(element, elementToCount.getOrDefault(element, 0) + 1);
    }

    return IntStream.range(0, N)
        .map(i -> elementToCount.get(new Element(roadLeaders[i], railwayLeaders[i])))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int[] buildLeaders(int N, int[] x, int[] y) {
    Dsu dsu = new Dsu(N);
    for (int i = 0; i < x.length; ++i) {
      dsu.union(x[i] - 1, y[i] - 1);
    }

    return IntStream.range(0, N).map(dsu::find).toArray();
  }
}

record Element(int roadLeader, int railwayLeader) {}

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
