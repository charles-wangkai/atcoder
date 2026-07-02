import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
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
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int Ai : A) {
      valueToCount.put(Ai, valueToCount.getOrDefault(Ai, 0) + 1);
    }

    OptionalInt maxUniqueValue =
        valueToCount.keySet().stream()
            .filter(value -> valueToCount.get(value) == 1)
            .mapToInt(Integer::intValue)
            .max();
    if (maxUniqueValue.isEmpty()) {
      return -1;
    }

    return IntStream.range(0, A.length)
            .filter(i -> A[i] == maxUniqueValue.getAsInt())
            .findAny()
            .getAsInt()
        + 1;
  }
}