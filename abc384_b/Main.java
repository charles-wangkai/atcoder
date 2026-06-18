import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int R = sc.nextInt();
    int[] D = new int[N];
    int[] A = new int[N];
    for (int i = 0; i < N; ++i) {
      D[i] = sc.nextInt();
      A[i] = sc.nextInt();
    }

    System.out.println(solve(D, A, R));

    sc.close();
  }

  static int solve(int[] D, int[] A, int R) {
    for (int i = 0; i < D.length; ++i) {
      int minRating;
      int maxRating;
      if (D[i] == 1) {
        minRating = 1600;
        maxRating = 2799;
      } else {
        minRating = 1200;
        maxRating = 2399;
      }

      if (R >= minRating && R <= maxRating) {
        R += A[i];
      }
    }

    return R;
  }
}