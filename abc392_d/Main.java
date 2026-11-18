import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[][] A = new int[N][];
      for (int i = 0; i < A.length; ++i) {
        int K = sc.nextInt();
        A[i] = new int[K];
        for (int j = 0; j < A[i].length; ++j) {
          A[i][j] = sc.nextInt();
        }
      }

      System.out.printf("%.9f\n", solve(A));
    }
  }

  static double solve(int[][] A) {
    double result = 0;
    for (int i = 0; i < A.length; ++i) {
      Map<Integer, Integer> valueToCount1 = buildValueToCount(A[i]);
      for (int j = i + 1; j < A.length; ++j) {
        Map<Integer, Integer> valueToCount2 = buildValueToCount(A[j]);

        int i_ = i;
        int j_ = j;
        result =
            Math.max(
                result,
                valueToCount1.keySet().stream()
                    .mapToDouble(value ->
                        (double) valueToCount1.get(value)
                            / A[i_].length
                            * valueToCount2.getOrDefault(value, 0)
                            / A[j_].length)
                    .sum());
      }
    }

    return result;
  }

  static Map<Integer, Integer> buildValueToCount(int[] values) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : values) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    return valueToCount;
  }
}