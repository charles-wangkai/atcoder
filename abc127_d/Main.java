import java.util.Arrays;
import java.util.Comparator;
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
    int[] B = new int[M];
    int[] C = new int[M];
    for (int i = 0; i < M; ++i) {
      B[i] = sc.nextInt();
      C[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, C));

    sc.close();
  }

  static long solve(int[] A, int[] B, int[] C) {
    Arrays.sort(A);

    int[] sortedIndices =
        IntStream.range(0, B.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> C[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    int index = 0;
    for (int i = 0; i < A.length; ++i) {
      if (index != sortedIndices.length && C[sortedIndices[index]] > A[i]) {
        A[i] = C[sortedIndices[index]];

        --B[sortedIndices[index]];
        if (B[sortedIndices[index]] == 0) {
          ++index;
        }
      }
    }

    return Arrays.stream(A).asLongStream().sum();
  }
}