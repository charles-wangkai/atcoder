import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
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
    Map<Integer, Integer> valueToGcdness =
        IntStream.rangeClosed(2, Arrays.stream(A).max().getAsInt())
            .boxed()
            .collect(
                Collectors.toMap(
                    value -> value,
                    value -> (int) Arrays.stream(A).filter(Ai -> Ai % value == 0).count()));
    int maxGcdness = valueToGcdness.values().stream().mapToInt(Integer::intValue).max().getAsInt();

    return valueToGcdness.keySet().stream()
        .filter(value -> valueToGcdness.get(value) == maxGcdness)
        .findAny()
        .get();
  }
}