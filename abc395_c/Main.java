import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

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

  static int solve(int[] A) {
    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < A.length; ++i) {
      valueToIndices.putIfAbsent(A[i], new ArrayList<>());
      valueToIndices.get(A[i]).add(i);
    }

    return valueToIndices.values().stream()
        .flatMapToInt(
            indices ->
                IntStream.range(0, indices.size() - 1)
                    .map(i -> indices.get(i + 1) - indices.get(i) + 1))
        .min()
        .orElse(-1);
  }
}