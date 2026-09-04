import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int Q = sc.nextInt();
    int[] A = new int[K];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] L = new int[Q];
    for (int i = 0; i < L.length; ++i) {
      L[i] = sc.nextInt();
    }

    System.out.println(solve(N, A, L));

    sc.close();
  }

  static String solve(int N, int[] A, int[] L) {
    for (int Li : L) {
      int next = (Li == A.length) ? (N + 1) : A[Li];
      A[Li - 1] = Math.min(next - 1, A[Li - 1] + 1);
    }

    return Arrays.stream(A).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}