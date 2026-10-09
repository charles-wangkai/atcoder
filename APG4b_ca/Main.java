import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N];
    int[] b = new int[N];
    for (int i = 0; i < N; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    int[] sortedIndices =
        IntStream.range(0, b.length)
            .boxed()
            .sorted(Comparator.comparing(i -> b[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    return Arrays.stream(sortedIndices)
        .mapToObj(index -> "%d %d".formatted(a[index], b[index]))
        .collect(Collectors.joining("\n"));
  }
}