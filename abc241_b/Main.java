import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[M];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] A, int[] B) {
    Map<Integer, Integer> aValueToCount = buildValueToCount(A);
    Map<Integer, Integer> bValueToCount = buildValueToCount(B);

    return bValueToCount.keySet().stream()
        .allMatch(bValue -> aValueToCount.getOrDefault(bValue, 0) >= bValueToCount.get(bValue));
  }

  static Map<Integer, Integer> buildValueToCount(int[] values) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : values) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    return valueToCount;
  }
}