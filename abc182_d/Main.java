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
    long result = Long.MIN_VALUE;
    long pos = 0;
    long sum = 0;
    long max = 0;
    for (int Ai : A) {
      sum += Ai;
      max = Math.max(max, sum);

      result = Math.max(result, pos + max);

      pos += sum;
    }

    return result;
  }
}