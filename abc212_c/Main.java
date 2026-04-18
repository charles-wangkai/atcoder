import java.util.Arrays;
import java.util.Scanner;

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
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int[] A, int[] B) {
    Arrays.sort(A);
    Arrays.sort(B);

    int result = Integer.MAX_VALUE;
    int aIndex = 0;
    int bIndex = 0;
    while (aIndex != A.length && bIndex != B.length) {
      if (A[aIndex] <= B[bIndex]) {
        result = Math.min(result, B[bIndex] - A[aIndex]);
        ++aIndex;
      } else {
        result = Math.min(result, A[aIndex] - B[bIndex]);
        ++bIndex;
      }
    }

    return result;
  }
}