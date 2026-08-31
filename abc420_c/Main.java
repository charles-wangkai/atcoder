import java.util.Arrays;
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
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }
    char[] c = new char[Q];
    int[] X = new int[Q];
    int[] V = new int[Q];
    for (int i = 0; i < Q; ++i) {
      c[i] = sc.next().charAt(0);
      X[i] = sc.nextInt();
      V[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, c, X, V));

    sc.close();
  }

  static String solve(int[] A, int[] B, char[] c, int[] X, int[] V) {
    int N = A.length;
    int Q = c.length;

    long minSum = IntStream.range(0, N).map(i -> Math.min(A[i], B[i])).asLongStream().sum();

    long[] result = new long[Q];
    for (int i = 0; i < result.length; ++i) {
      int index = X[i] - 1;

      minSum -= Math.min(A[index], B[index]);

      if (c[i] == 'A') {
        A[index] = V[i];
      } else {
        B[index] = V[i];
      }

      minSum += Math.min(A[index], B[index]);

      result[i] = minSum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}