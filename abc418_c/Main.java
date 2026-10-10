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
    int[] B = new int[Q];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static String solve(int[] A, int[] B) {
    Arrays.sort(A);

    long[] result = new long[B.length];
    Arrays.fill(result, -1);

    int[] sortedQueryIndices =
        IntStream.range(0, B.length)
            .filter(i -> B[i] <= A[A.length - 1])
            .boxed()
            .sorted(Comparator.comparing(i -> B[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    int aIndex = -1;
    long lowerSum = 0;

    for (int queryIndex : sortedQueryIndices) {
      while (aIndex != A.length - 1 && A[aIndex + 1] <= B[queryIndex] - 1) {
        ++aIndex;
        lowerSum += A[aIndex];
      }

      result[queryIndex] = lowerSum + (A.length - aIndex - 1L) * (B[queryIndex] - 1) + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}