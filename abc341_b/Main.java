import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] S = new int[N - 1];
    int[] T = new int[N - 1];
    for (int i = 0; i < N - 1; ++i) {
      S[i] = sc.nextInt();
      T[i] = sc.nextInt();
    }

    System.out.println(solve(A, S, T));

    sc.close();
  }

  static long solve(int[] A, int[] S, int[] T) {
    long result = A[0];
    for (int i = 0; i < S.length; ++i) {
      result = result / S[i] * T[i] + A[i + 1];
    }

    return result;
  }
}