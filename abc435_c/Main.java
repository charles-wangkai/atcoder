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
    int maxIndex = 0;
    for (int i = 0; i < A.length && i <= maxIndex; ++i) {
      maxIndex = Math.min(A.length - 1, Math.max(maxIndex, i + A[i] - 1));
    }

    return maxIndex + 1;
  }
}