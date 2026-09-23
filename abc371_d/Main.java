import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] X = new int[N];
    for (int i = 0; i < X.length; ++i) {
      X[i] = sc.nextInt();
    }
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }
    int Q = sc.nextInt();
    int[] L = new int[Q];
    int[] R = new int[Q];
    for (int i = 0; i < Q; ++i) {
      L[i] = sc.nextInt();
      R[i] = sc.nextInt();
    }

    System.out.println(solve(X, P, L, R));

    sc.close();
  }

  static String solve(int[] X, int[] P, int[] L, int[] R) {
    long[] prefixSums = new long[P.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + P[i - 1];
    }

    return IntStream.range(0, L.length)
        .mapToLong(
            i -> {
              int leftIndex = findLeftIndex(X, L[i]);
              int rightIndex = findRightIndex(X, R[i]);

              return (leftIndex <= rightIndex)
                  ? (prefixSums[rightIndex + 1] - prefixSums[leftIndex])
                  : 0;
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int findLeftIndex(int[] X, int target) {
    int index = Arrays.binarySearch(X, target);
    if (index < 0) {
      index = -1 - index;
    }

    return index;
  }

  static int findRightIndex(int[] X, int target) {
    int index = Arrays.binarySearch(X, target);
    if (index < 0) {
      index = -2 - index;
    }

    return index;
  }
}