import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();
    int[] U = new int[N - 1];
    int[] V = new int[N - 1];
    for (int i = 0; i < N - 1; ++i) {
      U[i] = sc.nextInt();
      V[i] = sc.nextInt();
    }

    System.out.println(solve(U, V, X, Y));

    sc.close();
  }

  static String solve(int[] U, int[] V, int X, int Y) {
    int N = U.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[N];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < U.length; ++i) {
      adjLists[U[i] - 1].add(V[i] - 1);
      adjLists[V[i] - 1].add(U[i] - 1);
    }

    return search(adjLists, Y - 1, new ArrayList<>(), -1, X - 1).stream()
        .map(node -> node + 1)
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static List<Integer> search(
      List<Integer>[] adjLists, int target, List<Integer> path, int parent, int node) {
    path.add(node);

    if (node == target) {
      return path;
    }

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        List<Integer> p = search(adjLists, target, path, node, adj);
        if (p != null) {
          return p;
        }
      }
    }

    path.removeLast();

    return null;
  }
}