import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, K));

    sc.close();
  }

  static String solve(int[] A, int K) {
    for (int i = 0; i < K; ++i) {
      for (int j = 0; j < A.length - 1; ++j) {
        A[j] = A[j + 1];
      }
      A[A.length - 1] = 0;
    }

    return Arrays.stream(A).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}