import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int Q = sc.nextInt();
    int[] B = new int[Q];
    int[] C = new int[Q];
    for (int i = 0; i < Q; ++i) {
      B[i] = sc.nextInt();
      C[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, C));

    sc.close();
  }

  static String solve(int[] A, int[] B, int[] C) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int Ai : A) {
      valueToCount.put(Ai, valueToCount.getOrDefault(Ai, 0) + 1);
    }

    long[] result = new long[B.length];
    long sum = Arrays.stream(A).asLongStream().sum();
    for (int i = 0; i < result.length; ++i) {
      int count = valueToCount.getOrDefault(B[i], 0);

      valueToCount.remove(B[i]);
      valueToCount.put(C[i], valueToCount.getOrDefault(C[i], 0) + count);

      sum += (long) (C[i] - B[i]) * count;
      result[i] = sum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}