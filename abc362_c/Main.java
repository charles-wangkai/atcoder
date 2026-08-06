import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] L = new int[N];
    int[] R = new int[N];
    for (int i = 0; i < N; ++i) {
      L[i] = sc.nextInt();
      R[i] = sc.nextInt();
    }

    System.out.println(solve(L, R));

    sc.close();
  }

  static String solve(int[] L, int[] R) {
    if (Arrays.stream(L).asLongStream().sum() > 0 || Arrays.stream(R).asLongStream().sum() < 0) {
      return "No";
    }

    long delta = -Arrays.stream(L).asLongStream().sum();
    int[] X = L.clone();
    int[] sortedIndices =
        IntStream.range(0, L.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> R[i] - L[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();
    for (int index : sortedIndices) {
      int d = (int) Math.min(R[index] - L[index], delta);
      X[index] += d;
      delta -= d;
    }

    return "Yes\n%s"
        .formatted(Arrays.stream(X).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }
}