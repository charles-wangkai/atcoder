import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] x = new int[Q];
    int[] k = new int[Q];
    for (int i = 0; i < Q; ++i) {
      x[i] = sc.nextInt();
      k[i] = sc.nextInt();
    }

    System.out.println(solve(a, x, k));

    sc.close();
  }

  static String solve(int[] a, int[] x, int[] k) {
    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      valueToIndices.putIfAbsent(a[i], new ArrayList<>());
      valueToIndices.get(a[i]).add(i);
    }

    return IntStream.range(0, x.length)
        .map(
            i ->
                (valueToIndices.containsKey(x[i]) && k[i] <= valueToIndices.get(x[i]).size())
                    ? (valueToIndices.get(x[i]).get(k[i] - 1) + 1)
                    : -1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}