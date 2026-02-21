import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] t = new int[Q];
    int[] u = new int[Q];
    int[] v = new int[Q];
    for (int i = 0; i < Q; ++i) {
      t[i] = sc.nextInt();
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(N, t, u, v));

    sc.close();
  }

  static String solve(int N, int[] t, int[] u, int[] v) {
    List<Integer> result = new ArrayList<>();
    Dsu dsu = new Dsu(N);
    for (int i = 0; i < t.length; ++i) {
      if (t[i] == 0) {
        dsu.union(u[i], v[i]);
      } else {
        result.add((dsu.find(u[i]) == dsu.find(v[i])) ? 1 : 0);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
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
