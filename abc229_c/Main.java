import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int W = sc.nextInt();
    int[] A = new int[N];
    int[] B = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, W));

    sc.close();
  }

  static long solve(int[] A, int[] B, int W) {
    int[] sortedIndices =
        IntStream.range(0, A.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> A[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    long result = 0;
    for (int index : sortedIndices) {
      int gram = Math.min(W, B[index]);
      result += (long) A[index] * gram;
      W -= gram;
    }

    return result;
  }
}