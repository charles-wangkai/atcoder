import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

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

    return IntStream.range(0, N)
        .map(
            i -> {
              Set<Integer> seen = new HashSet<>();
              search(seen, adjLists, i);

              return seen.size();
            })
        .sum();
  }

  static void search(Set<Integer> seen, List<Integer>[] adjLists, int node) {
    if (!seen.contains(node)) {
      seen.add(node);

      for (int adj : adjLists[node]) {
        search(seen, adjLists, adj);
      }
    }
  }
}