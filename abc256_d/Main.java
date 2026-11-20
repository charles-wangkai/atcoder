import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] L = new int[N];
      int[] R = new int[N];
      for (int i = 0; i < N; ++i) {
        L[i] = sc.nextInt();
        R[i] = sc.nextInt();
      }

      System.out.println(solve(L, R));
    }
  }

  static String solve(int[] L, int[] R) {
    int[] sortedIndices =
        IntStream.range(0, L.length)
            .boxed()
            .sorted(Comparator.comparing(i -> L[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    List<Interval> result = new ArrayList<>();
    for (int index : sortedIndices) {
      if (result.isEmpty() || L[index] > result.getLast().right) {
        result.add(new Interval(L[index], R[index]));
      } else {
        result.getLast().right = Math.max(result.getLast().right, R[index]);
      }
    }

    return result.stream()
        .map(interval -> "%d %d".formatted(interval.left, interval.right))
        .collect(Collectors.joining("\n"));
  }
}

class Interval {
  int left;
  int right;

  Interval(int left, int right) {
    this.left = left;
    this.right = right;
  }
}
