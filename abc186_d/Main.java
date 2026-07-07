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

    System.out.println(solve(A));

    sc.close();
  }

  static long solve(int[] A) {
    Arrays.sort(A);

    long result = 0;
    long sum = 0;
    for (int i = 0; i < A.length; ++i) {
      result += (long) A[i] * i - sum;
      sum += A[i];
    }

    return result;
  }
}