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
    int M = sc.nextInt();
    int[] L = new int[M];
    int[] R = new int[M];
    int[] D = new int[M];
    for (int i = 0; i < M; ++i) {
      L[i] = sc.nextInt();
      R[i] = sc.nextInt();
      D[i] = sc.nextInt();
    }

    System.out.println(solve(N, L, R, D) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N, int[] L, int[] R, int[] D) {
    Dsu dsu = new Dsu(N);
    for (int i = 0; i < L.length; ++i) {
      if (!dsu.union(L[i] - 1, R[i] - 1, D[i])) {
        return false;
      }
    }

    return true;
  }
}

class Dsu {
  int[] parentOrSizes;
  int[] deltas;

  Dsu(int n) {
    parentOrSizes = new int[n];
    Arrays.fill(parentOrSizes, -1);

    deltas = new int[n];
  }

  int find(int a) {
    if (parentOrSizes[a] < 0) {
      return a;
    }

    int parent = parentOrSizes[a];
    int leader = find(parent);
    deltas[a] += deltas[parent];
    parentOrSizes[a] = leader;

    return leader;
  }

  boolean union(int left, int right, int distance) {
    int leftLeader = find(left);
    int rightLeader = find(right);
    int offset = distance + deltas[left] - deltas[right];

    if (leftLeader == rightLeader) {
      if (offset != 0) {
        return false;
      }
    } else {
      parentOrSizes[leftLeader] += parentOrSizes[rightLeader];
      parentOrSizes[rightLeader] = leftLeader;

      deltas[rightLeader] = offset;
    }

    return true;
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
