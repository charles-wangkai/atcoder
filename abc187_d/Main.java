import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int[] A, int[] B) {
    long diff = -Arrays.stream(A).asLongStream().sum();

    long[] deltas =
        IntStream.range(0, A.length)
            .mapToLong(i -> 2L * A[i] + B[i])
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToLong(Long::longValue)
            .toArray();

    int result = 0;
    while (diff <= 0) {
      diff += deltas[result];
      ++result;
    }

    return result;
  }
}