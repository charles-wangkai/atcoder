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

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    int[] result = new int[A.length];
    Map<Integer, Integer> valueToLastIndex = new HashMap<>();
    for (int i = 0; i < result.length; ++i) {
      result[i] = valueToLastIndex.containsKey(A[i]) ? (valueToLastIndex.get(A[i]) + 1) : -1;
      valueToLastIndex.put(A[i], i);
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}