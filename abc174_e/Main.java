import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int K = sc.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < A.length; ++i) {
        A[i] = sc.nextInt();
      }

      System.out.println(solve(A, K));
    }
  }

  static int solve(int[] A, int K) {
    int result = -1;
    int lower = 1;
    int upper = Arrays.stream(A).max().getAsInt();
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(A, K, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] A, int K, int target) {
    return Arrays.stream(A).map(Ai -> Math.ceilDiv(Ai, target) - 1).asLongStream().sum() <= K;
  }
}