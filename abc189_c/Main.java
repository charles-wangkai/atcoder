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

  static int solve(int[] A) {
    int result = -1;
    for (int i = 0; i < A.length; ++i) {
      int min = Integer.MAX_VALUE;
      for (int j = i; j < A.length; ++j) {
        min = Math.min(min, A[j]);
        result = Math.max(result, min * (j - i + 1));
      }
    }

    return result;
  }
}