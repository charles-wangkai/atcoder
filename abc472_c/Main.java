import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    long K = sc.nextLong();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, M, K));

    sc.close();
  }

  static String solve(int[] A, int M, long K) {
    int N = A.length;

    boolean[] result = new boolean[N];
    int[] eaten = new int[N];
    long sum = 0;
    for (int i = 0; i < result.length; ++i) {
      if (sum + A[i] <= K) {
        result[i] = true;
        eaten[i] = A[i];
        sum += A[i];
      }

      if (i >= M - 1) {
        sum -= eaten[i - M + 1];
      }
    }

    return IntStream.range(0, result.length)
        .mapToObj(i -> result[i] ? "Yes" : "No")
        .collect(Collectors.joining("\n"));
  }
}