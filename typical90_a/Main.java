import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int L = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, L, K));

    sc.close();
  }

  static int solve(int[] A, int L, int K) {
    int[] segments =
        IntStream.range(0, A.length + 1)
            .map(i -> ((i == A.length) ? L : A[i]) - ((i == 0) ? 0 : A[i - 1]))
            .toArray();

    int result = -1;
    int lower = 1;
    int upper = L;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(K, segments, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int K, int[] segments, int target) {
    int count = 0;
    int sum = 0;
    for (int segment : segments) {
      sum += segment;
      if (sum >= target) {
        ++count;
        sum = 0;
      }
    }

    return count >= K + 1;
  }
}