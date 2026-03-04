import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] p = new int[N];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }
    int[] x = new int[M];
    int[] y = new int[M];
    for (int i = 0; i < M; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(p, x, y));

    sc.close();
  }

  static int solve(int[] p, int[] x, int[] y) {
    int N = p.length;

    Dsu dsu = new Dsu(N);
    for (int i = 0; i < x.length; ++i) {
      dsu.union(x[i] - 1, y[i] - 1);
    }

    return dsu.buildLeaderToGroup().values().stream()
        .mapToInt(
            group -> (int) group.stream().filter(index -> group.contains(p[index] - 1)).count())
        .sum();
  }
}

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

  Map<Integer, Set<Integer>> buildLeaderToGroup() {
    Map<Integer, Set<Integer>> leaderToGroup = new HashMap<>();
    for (int i = 0; i < parentOrSizes.length; ++i) {
      int leader = find(i);
      leaderToGroup.putIfAbsent(leader, new HashSet<>());
      leaderToGroup.get(leader).add(i);
    }

    return leaderToGroup;
  }
}
