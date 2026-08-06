import java.util.Arrays;
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
    int[] C = IntStream.concat(Arrays.stream(A), Arrays.stream(B)).sorted().toArray();
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, C.length).boxed().collect(Collectors.toMap(i -> C[i], i -> i));

    return "%s\n%s"
        .formatted(
            Arrays.stream(A)
                .map(Ai -> valueToIndex.get(Ai) + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")),
            Arrays.stream(B)
                .map(Bi -> valueToIndex.get(Bi) + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}