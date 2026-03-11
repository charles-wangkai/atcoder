import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int S = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(A, P, S));

    sc.close();
  }

  static int solve(int[] A, int[] P, int S) {
    int result = 0;
    for (int Ai : A) {
      for (int Pi : P) {
        if (Ai + Pi == S) {
          ++result;
        }
      }
    }

    return result;
  }
}