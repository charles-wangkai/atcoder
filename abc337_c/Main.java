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

  static String solve(int[] A) {
    int N = A.length;

    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, A.length).boxed().collect(Collectors.toMap(i -> A[i], i -> i));

    int[] result = new int[N];
    int prev = -1;
    for (int i = 0; i < result.length; ++i) {
      prev = valueToIndex.get(prev) + 1;
      result[i] = prev;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}