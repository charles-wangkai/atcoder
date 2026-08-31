import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] W = new int[N];
    for (int i = 0; i < W.length; ++i) {
      W[i] = sc.nextInt();
    }

    System.out.println(solve(A, W));

    sc.close();
  }

  static int solve(int[] A, int[] W) {
    Map<Integer, List<Integer>> boxToWeights = new HashMap<>();
    for (int i = 0; i < A.length; ++i) {
      boxToWeights.putIfAbsent(A[i], new ArrayList<>());
      boxToWeights.get(A[i]).add(W[i]);
    }

    return boxToWeights.values().stream()
        .mapToInt(
            weights ->
                weights.stream()
                    .sorted(Comparator.reverseOrder())
                    .skip(1)
                    .mapToInt(Integer::intValue)
                    .sum())
        .sum();
  }
}