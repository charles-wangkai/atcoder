import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long M = sc.nextLong();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, M));

    sc.close();
  }

  static String solve(int[] A, long M) {
    if (Arrays.stream(A).asLongStream().sum() <= M) {
      return "infinite";
    }

    int result = -1;
    int lower = 0;
    int upper = Arrays.stream(A).max().getAsInt();
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(A, M, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return String.valueOf(result);
  }

  static boolean check(int[] A, long M, int x) {
    return Arrays.stream(A).map(Ai -> Math.min(Ai, x)).asLongStream().sum() <= M;
  }
}