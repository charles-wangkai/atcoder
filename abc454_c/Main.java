import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    int[] B = new int[M];
    for (int i = 0; i < M; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(N, A, B));

    sc.close();
  }

  static int solve(int N, int[] A, int[] B) {
    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[N];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < A.length; ++i) {
      adjLists[A[i] - 1].add(B[i] - 1);
    }

    Set<Integer> visited = new HashSet<>();
    search(visited, adjLists, 0);

    return visited.size();
  }

  static void search(Set<Integer> visited, List<Integer>[] adjLists, int node) {
    visited.add(node);

    for (int adj : adjLists[node]) {
      if (!visited.contains(adj)) {
        search(visited, adjLists, adj);
      }
    }
  }
}