import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, M));

    sc.close();
  }

  static long solve(int[] A, int M) {
    long result = Long.MIN_VALUE;
    long sum = IntStream.range(0, M - 1).map(i -> A[i]).asLongStream().sum();
    long weightedSum = IntStream.range(0, M - 1).mapToLong(i -> (i + 1L) * A[i]).sum();
    for (int i = M - 1; i < A.length; ++i) {
      sum += A[i];
      weightedSum += (long) M * A[i];

      result = Math.max(result, weightedSum);

      weightedSum -= sum;
      sum -= A[i - M + 1];
    }

    return result;
  }
}