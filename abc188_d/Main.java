import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int C = sc.nextInt();
      int[] a = new int[N];
      int[] b = new int[N];
      int[] c = new int[N];
      for (int i = 0; i < N; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
        c[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, c, C));
    }
  }

  static long solve(int[] a, int[] b, int[] c, int C) {
    int[] days =
        IntStream.concat(Arrays.stream(a), Arrays.stream(b).map(bi -> bi + 1))
            .distinct()
            .sorted()
            .toArray();
    Map<Integer, Integer> dayToIndex =
        IntStream.range(0, days.length).boxed().collect(Collectors.toMap(i -> days[i], i -> i));

    long[] deltas = new long[days.length];
    for (int i = 0; i < a.length; ++i) {
      deltas[dayToIndex.get(a[i])] += c[i];
      deltas[dayToIndex.get(b[i] + 1)] -= c[i];
    }

    long result = 0;
    long price = 0;
    for (int i = 0; i < days.length - 1; ++i) {
      price += deltas[i];
      result += Math.min(C, price) * (days[i + 1] - days[i]);
    }

    return result;
  }
}