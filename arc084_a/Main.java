import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }
    int[] C = new int[N];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextInt();
    }

    System.out.println(solve(A, B, C));

    sc.close();
  }

  static long solve(int[] A, int[] B, int[] C) {
    Arrays.sort(A);
    Arrays.sort(C);

    return Arrays.stream(B)
        .mapToLong(b -> (long) computeLessNum(A, b) * computeGreaterNum(C, b))
        .sum();
  }

  static int computeLessNum(int[] values, int target) {
    int index = -1;
    int lower = 0;
    int upper = values.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (values[middle] < target) {
        index = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return index + 1;
  }

  static int computeGreaterNum(int[] values, int target) {
    int index = values.length;
    int lower = 0;
    int upper = values.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (values[middle] > target) {
        index = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return values.length - index;
  }
}