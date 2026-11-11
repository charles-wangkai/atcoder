import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] u = new int[M];
    int[] v = new int[M];
    long[] w = new long[M];
    for (int i = 0; i < M; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
      w[i] = sc.nextLong();
    }

    System.out.println(solve(N, u, v, w));

    sc.close();
  }

  static long solve(int N, int[] u, int[] v, long[] w) {
    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[N];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      edgeLists[u[i] - 1].add(i);
      edgeLists[v[i] - 1].add(i);
    }

    return search(u, v, w, edgeLists, new boolean[N], 0, 0);
  }

  static long search(
      int[] u,
      int[] v,
      long[] w,
      List<Integer>[] edgeLists,
      boolean[] visited,
      long xor,
      int node) {
    int N = edgeLists.length;

    if (node == N - 1) {
      return xor;
    }

    visited[node] = true;

    long result = Long.MAX_VALUE;
    for (int edge : edgeLists[node]) {
      int adj = (u[edge] - 1 == node) ? (v[edge] - 1) : (u[edge] - 1);
      if (!visited[adj]) {
        result = Math.min(result, search(u, v, w, edgeLists, visited, xor ^ w[edge], adj));
      }
    }

    visited[node] = false;

    return result;
  }
}