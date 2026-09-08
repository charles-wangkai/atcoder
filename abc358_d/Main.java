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

  static long solve(int[] A, int[] B) {
    Arrays.sort(A);
    Arrays.sort(B);

    long result = 0;
    int index = 0;
    for (int Bi : B) {
      while (index != A.length && A[index] < Bi) {
        ++index;
      }
      if (index == A.length) {
        return -1;
      }

      result += A[index];
      ++index;
    }

    return result;
  }
}