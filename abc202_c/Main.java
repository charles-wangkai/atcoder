import java.util.Arrays;
import java.util.HashMap;
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
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }
    int[] C = new int[N];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, C));

    sc.close();
  }

  static long solve(int[] A, int[] B, int[] C) {
    Map<Integer, Integer> valueToCount1 = buildValueToCount(A);
    Map<Integer, Integer> valueToCount2 =
        buildValueToCount(Arrays.stream(C).map(Ci -> B[Ci - 1]).toArray());

    return valueToCount1.keySet().stream()
        .mapToLong(value -> (long) valueToCount1.get(value) * valueToCount2.getOrDefault(value, 0))
        .sum();
  }

  static Map<Integer, Integer> buildValueToCount(int[] values) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : values) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    return valueToCount;
  }
}