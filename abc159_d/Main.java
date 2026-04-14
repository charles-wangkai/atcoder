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
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int Ai : A) {
      valueToCount.put(Ai, valueToCount.getOrDefault(Ai, 0) + 1);
    }

    long pairNum =
        valueToCount.values().stream().mapToLong(count -> count * (count - 1L) / 2).sum();

    return Arrays.stream(A)
        .mapToLong(Ai -> pairNum - (valueToCount.get(Ai) - 1))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}