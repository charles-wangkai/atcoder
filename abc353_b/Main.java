import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, K));

    sc.close();
  }

  static int solve(int[] A, int K) {
    int result = 0;
    int index = 0;
    while (index != A.length) {
      int rest = K;
      while (index != A.length && A[index] <= rest) {
        rest -= A[index];
        ++index;
      }

      ++result;
    }

    return result;
  }
}