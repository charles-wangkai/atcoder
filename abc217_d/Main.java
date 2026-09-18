import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int L = sc.nextInt();
    int Q = sc.nextInt();
    int[] c = new int[Q];
    int[] x = new int[Q];
    for (int i = 0; i < Q; ++i) {
      c[i] = sc.nextInt();
      x[i] = sc.nextInt();
    }

    System.out.println(solve(L, c, x));

    sc.close();
  }

  static String solve(int L, int[] c, int[] x) {
    NavigableSet<Integer> cuts = new TreeSet<>();
    cuts.add(0);
    cuts.add(L);

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < c.length; ++i) {
      if (c[i] == 1) {
        cuts.add(x[i]);
      } else {
        result.add(cuts.higher(x[i]) - cuts.lower(x[i]));
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}