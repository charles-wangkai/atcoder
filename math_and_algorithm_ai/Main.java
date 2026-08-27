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
    int[] L = new int[Q];
    int[] R = new int[Q];
    for (int i = 0; i < Q; ++i) {
      L[i] = sc.nextInt();
      R[i] = sc.nextInt();
    }

    System.out.println(solve(A, L, R));

    sc.close();
  }

  static String solve(int[] A, int[] L, int[] R) {
    int[] prefixSums = new int[A.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + A[i - 1];
    }

    return IntStream.range(0, L.length)
        .map(i -> prefixSums[R[i]] - prefixSums[L[i] - 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}