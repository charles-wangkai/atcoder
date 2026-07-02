import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] x = new int[Q];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }

    System.out.println(solve(A, x));

    sc.close();
  }

  static String solve(int[] A, int[] x) {
    int[] sorted =
        Arrays.stream(A)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    int[] queryIndices =
        IntStream.range(0, x.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> x[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    int[] result = new int[x.length];
    int count = 0;
    for (int queryIndex : queryIndices) {
      while (count != sorted.length && sorted[count] >= x[queryIndex]) {
        ++count;
      }

      result[queryIndex] = count;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}