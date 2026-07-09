import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[M];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, K));

    sc.close();
  }

  static int solve(int[] A, int[] B, int K) {
    int result = 0;
    int sumA = 0;
    int countB = B.length;
    long sumB = Arrays.stream(B).asLongStream().sum();
    for (int countA = 0; countA <= A.length; ++countA) {
      if (countA != 0) {
        sumA += A[countA - 1];
        if (sumA > K) {
          break;
        }
      }

      while (sumA + sumB > K) {
        sumB -= B[countB - 1];
        --countB;
      }

      result = Math.max(result, countA + countB);
    }

    return result;
  }
}