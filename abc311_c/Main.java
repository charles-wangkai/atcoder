import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    int start = findStart(A);

    List<Integer> cycle = new ArrayList<>();
    Set<Integer> seen = new HashSet<>();
    int node = start;
    while (!seen.contains(node)) {
      cycle.add(node);
      seen.add(node);

      node = A[node] - 1;
    }

    return "%d\n%s"
        .formatted(
            cycle.size(),
            cycle.stream().map(x -> x + 1).map(String::valueOf).collect(Collectors.joining(" ")));
  }

  static int findStart(int[] A) {
    Set<Integer> seen = new HashSet<>();
    int node = 0;
    while (true) {
      if (seen.contains(node)) {
        return node;
      }

      seen.add(node);
      node = A[node] - 1;
    }
  }
}