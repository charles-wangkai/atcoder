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

    int result = 0;
    int bIndex = B.length - 1;
    for (int i = A.length - 1; i >= 0; --i) {
      while (bIndex != -1 && B[bIndex] > A[i] * 2) {
        --bIndex;
      }

      if (bIndex != -1) {
        ++result;
        --bIndex;
      }
    }

    return result;
  }
}