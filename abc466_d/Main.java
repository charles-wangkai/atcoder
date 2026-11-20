import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[] R = new int[M];
      int[] C = new int[M];
      for (int i = 0; i < M; ++i) {
        R[i] = sc.nextInt();
        C[i] = sc.nextInt();
      }

      System.out.println(solve(N, R, C));
    }
  }

  static int solve(int N, int[] R, int[] C) {
    Map<Integer, Set<Integer>> rToCs = new HashMap<>();
    Map<Integer, Set<Integer>> cToRs = new HashMap<>();
    for (int i = 0; i < R.length; ++i) {
      for (int c : rToCs.getOrDefault(R[i], Set.of())) {
        cToRs.get(c).remove(R[i]);
      }
      rToCs.remove(R[i]);

      for (int r : cToRs.getOrDefault(C[i], Set.of())) {
        rToCs.get(r).remove(C[i]);
      }
      cToRs.remove(C[i]);

      rToCs.put(R[i], new HashSet<>());
      rToCs.get(R[i]).add(C[i]);

      cToRs.put(C[i], new HashSet<>());
      cToRs.get(C[i]).add(R[i]);
    }

    return rToCs.values().stream().mapToInt(Set::size).sum();
  }
}