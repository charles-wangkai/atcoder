import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    System.out.println(solve(A, B));

    sc.close();
  }

  static String solve(int[] A, int[] B) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int Ai : A) {
      valueToCount.put(Ai, valueToCount.getOrDefault(Ai, 0) + 1);
    }
    for (int Bi : B) {
      valueToCount.put(Bi, Math.max(0, valueToCount.getOrDefault(Bi, 0) - 1));
    }

    return valueToCount.keySet().stream()
        .sorted()
        .flatMap(value -> IntStream.range(0, valueToCount.get(value)).mapToObj(i -> value))
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}