import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[3 * N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(int[] A) {
    int N = A.length / 3;

    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < A.length; ++i) {
      valueToIndices.putIfAbsent(A[i], new ArrayList<>());
      valueToIndices.get(A[i]).add(i);
    }

    return IntStream.rangeClosed(1, N)
        .boxed()
        .sorted(Comparator.comparing(value -> valueToIndices.get(value).get(1)))
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}