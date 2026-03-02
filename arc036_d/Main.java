import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] w = new int[Q];
    int[] x = new int[Q];
    int[] y = new int[Q];
    int[] z = new int[Q];
    for (int i = 0; i < Q; ++i) {
      w[i] = sc.nextInt();
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
      z[i] = sc.nextInt();
    }

    System.out.println(solve(N, w, x, y, z));

    sc.close();
  }

  static String solve(int N, int[] w, int[] x, int[] y, int[] z) {
    List<String> result = new ArrayList<>();

    Dsu dsu = new Dsu(N);

    int[] opposites = new int[N];
    Arrays.fill(opposites, -1);

    for (int i = 0; i < w.length; ++i) {
      int leaderX = dsu.find(x[i] - 1);
      int leaderY = dsu.find(y[i] - 1);

      if (w[i] == 1) {
        if (z[i] % 2 == 0) {
          union(dsu, opposites, x[i] - 1, y[i] - 1);
        } else {
          union(dsu, opposites, opposites[leaderX], y[i] - 1);
          opposites[leaderX] = y[i] - 1;

          union(dsu, opposites, x[i] - 1, opposites[leaderY]);
          opposites[leaderY] = x[i] - 1;
        }
      } else {
        result.add((leaderX == leaderY) ? "YES" : "NO");
      }
    }

    return String.join("\n", result);
  }

  static void union(Dsu dsu, int[] opposites, int node1, int node2) {
    if (node1 == -1 || node2 == -1) {
      return;
    }

    int leader1 = dsu.find(node1);
    int leader2 = dsu.find(node2);
    if (leader1 == leader2) {
      return;
    }

    dsu.union(leader1, leader2);

    union(dsu, opposites, opposites[leader1], opposites[leader2]);
    if (opposites[leader1] != -1) {
      opposites[leader2] = opposites[leader1];
    }
    if (opposites[leader2] != -1) {
      opposites[leader1] = opposites[leader2];
    }
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
