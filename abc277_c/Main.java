import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int[] A, int[] B) {
    Map<Integer, List<Integer>> nodeToAdjs = new HashMap<>();
    for (int i = 0; i < A.length; ++i) {
      nodeToAdjs.putIfAbsent(A[i], new ArrayList<>());
      nodeToAdjs.get(A[i]).add(B[i]);

      nodeToAdjs.putIfAbsent(B[i], new ArrayList<>());
      nodeToAdjs.get(B[i]).add(A[i]);
    }

    Set<Integer> visited = new HashSet<>();
    search(visited, nodeToAdjs, 1);

    return visited.stream().mapToInt(Integer::intValue).max().getAsInt();
  }

  static void search(Set<Integer> visited, Map<Integer, List<Integer>> nodeToAdjs, int node) {
    visited.add(node);

    for (int adj : nodeToAdjs.getOrDefault(node, List.of())) {
      if (!visited.contains(adj)) {
        search(visited, nodeToAdjs, adj);
      }
    }
  }
}