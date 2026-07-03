import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long K = sc.nextLong();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, K));

    sc.close();
  }

  static String solve(int[] a, long K) {
    int N = a.length;

    long[] result = new long[N];
    Arrays.fill(result, K / N);

    int[] indices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.comparing(i -> a[i]))
            .limit(K % N)
            .mapToInt(Integer::intValue)
            .toArray();
    for (int index : indices) {
      ++result[index];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}