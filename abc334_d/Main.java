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
    int[] R = new int[N];
    for (int i = 0; i < R.length; ++i) {
      R[i] = sc.nextInt();
    }
    long[] X = new long[Q];
    for (int i = 0; i < X.length; ++i) {
      X[i] = sc.nextLong();
    }

    System.out.println(solve(R, X));

    sc.close();
  }

  static String solve(int[] R, long[] X) {
    Arrays.sort(R);

    int[] xSortedIndices =
        IntStream.range(0, X.length)
            .boxed()
            .sorted(Comparator.comparing(i -> X[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    int[] result = new int[X.length];
    int rIndex = -1;
    long sum = 0;
    for (int xIndex : xSortedIndices) {
      while (rIndex != R.length - 1 && sum + R[rIndex + 1] <= X[xIndex]) {
        ++rIndex;
        sum += R[rIndex];
      }

      result[xIndex] = rIndex + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}