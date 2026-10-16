import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(P, K));

    sc.close();
  }

  static int solve(int[] P, int K) {
    int N = P.length;

    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, P.length).boxed().collect(Collectors.toMap(i -> P[i], i -> i));

    SortedSet<Integer> indices = new TreeSet<>();
    for (int value = 1; value <= K - 1; ++value) {
      indices.add(valueToIndex.get(value));
    }

    int result = Integer.MAX_VALUE;
    for (int value = K; value <= N; ++value) {
      indices.add(valueToIndex.get(value));
      result = Math.min(result, indices.last() - indices.first());
      indices.remove(valueToIndex.get(value - K + 1));
    }

    return result;
  }
}