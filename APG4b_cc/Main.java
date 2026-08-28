import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] p = new int[N - 1];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }

    System.out.println(solve(p));

    sc.close();
  }

  static String solve(int[] p) {
    int N = p.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] childLists = new List[N];
    for (int i = 0; i < childLists.length; ++i) {
      childLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < p.length; ++i) {
      childLists[p[i]].add(i + 1);
    }

    int[] subtreeSizes = new int[N];
    search(subtreeSizes, childLists, 0);

    return Arrays.stream(subtreeSizes).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }

  static void search(int[] subtreeSizes, List<Integer>[] childLists, int node) {
    subtreeSizes[node] = 1;
    for (int child : childLists[node]) {
      search(subtreeSizes, childLists, child);
      subtreeSizes[node] += subtreeSizes[child];
    }
  }
}