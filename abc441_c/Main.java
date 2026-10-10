import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    long X = sc.nextLong();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, K, X));

    sc.close();
  }

  static int solve(int[] A, int K, long X) {
    Arrays.sort(A);

    if (IntStream.range(0, K).map(i -> A[i]).asLongStream().sum() < X) {
      return -1;
    }

    int result = A.length - K;
    long sum = 0;
    int index = K - 1;
    while (sum < X) {
      sum += A[index];
      --index;
      ++result;
    }

    return result;
  }
}