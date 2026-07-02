import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    long[] A = new long[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextLong();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, K));

    sc.close();
  }

  static long solve(long[] A, int[] B, int K) {
    int[] sortedIndices =
        IntStream.range(0, A.length)
            .boxed()
            .sorted(Comparator.comparing(i -> A[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    long result = K;
    for (int index : sortedIndices) {
      if (A[index] <= result) {
        result += B[index];
      }
    }

    return result;
  }
}