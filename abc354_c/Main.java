import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    int[] C = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      C[i] = sc.nextInt();
    }

    System.out.println(solve(A, C));

    sc.close();
  }

  static String solve(int[] A, int[] C) {
    int N = A.length;

    int[] sortedIndices =
        IntStream.range(0, N)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> A[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    List<Integer> kept = new ArrayList<>();
    int lastCost = Integer.MAX_VALUE;
    for (int index : sortedIndices) {
      if (C[index] < lastCost) {
        kept.add(index);
        lastCost = C[index];
      }
    }

    return "%d\n%s"
        .formatted(
            kept.size(),
            kept.stream()
                .sorted()
                .map(i -> i + 1)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}