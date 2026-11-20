import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] A = new int[N];
      int[] B = new int[N];
      for (int i = 0; i < N; ++i) {
        A[i] = sc.nextInt();
        B[i] = sc.nextInt();
      }

      System.out.println(solve(A, B));
    }
  }

  static int solve(int[] A, int[] B) {
    int N = A.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[N];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < A.length; ++i) {
      if (A[i] != 0) {
        adjLists[A[i] - 1].add(i);
        adjLists[B[i] - 1].add(i);
      }
    }

    boolean[] visited = new boolean[N];
    for (int i = 0; i < A.length; ++i) {
      if (A[i] == 0) {
        search(adjLists, visited, i);
      }
    }

    return (int) IntStream.range(0, visited.length).filter(i -> visited[i]).count();
  }

  static void search(List<Integer>[] adjLists, boolean[] visited, int node) {
    visited[node] = true;

    for (int adj : adjLists[node]) {
      if (!visited[adj]) {
        search(adjLists, visited, adj);
      }
    }
  }
}