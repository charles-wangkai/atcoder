import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long X = sc.nextLong();
    long Y = sc.nextLong();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, X, Y));

    sc.close();
  }

  static int solve(int[] A, int[] B, long X, long Y) {
    return Math.min(computeDishNum(A, X), computeDishNum(B, Y));
  }

  static int computeDishNum(int[] values, long limit) {
    Arrays.sort(values);

    int result = 0;
    long sum = 0;
    for (int i = values.length - 1; i >= 0; --i) {
      sum += values[i];
      ++result;

      if (sum > limit) {
        break;
      }
    }

    return result;
  }
}