import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    long[] A = new long[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextLong();
    }
    long[] K = new long[Q];
    for (int i = 0; i < K.length; ++i) {
      K[i] = sc.nextLong();
    }

    System.out.println(solve(A, K));

    sc.close();
  }

  static String solve(long[] A, long[] K) {
    return Arrays.stream(K)
        .map(Ki -> findKthSmallest(A, Ki))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static long findKthSmallest(long[] A, long k) {
    long result = -1;
    long lower = 1;
    long upper = k + A.length;
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      if (computeLessEqualNum(A, middle) >= k) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static long computeLessEqualNum(long[] A, long maxValue) {
    int index = Arrays.binarySearch(A, maxValue);
    if (index < 0) {
      index = -2 - index;
    }

    return maxValue - (index + 1);
  }
}