import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }
    int[] C = new int[N - 1];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, C));

    sc.close();
  }

  static int solve(int[] A, int[] B, int[] C) {
    return Arrays.stream(A).map(Ai -> B[Ai - 1]).sum()
        + IntStream.range(0, A.length - 1)
            .filter(i -> A[i] + 1 == A[i + 1])
            .map(i -> C[A[i] - 1])
            .sum();
  }
}