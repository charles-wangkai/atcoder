import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[K];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] X = new int[N];
    int[] Y = new int[N];
    for (int i = 0; i < N; ++i) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }

    System.out.printf("%.9f\n", solve(X, Y, A));

    sc.close();
  }

  static double solve(int[] X, int[] Y, int[] A) {
    double result = -1;
    double lower = 0;
    double upper = 400000;
    for (int i = 0; i < 100; ++i) {
      double middle = (lower + upper) / 2;
      if (check(X, Y, A, middle)) {
        result = middle;
        upper = middle;
      } else {
        lower = middle;
      }
    }

    return result;
  }

  static boolean check(int[] X, int[] Y, int[] A, double radius) {
    return IntStream.range(0, X.length)
        .allMatch(
            i ->
                Arrays.stream(A)
                    .anyMatch(Ai -> computeDistance(X[Ai - 1], Y[Ai - 1], X[i], Y[i]) <= radius));
  }

  static double computeDistance(int x1, int y1, int x2, int y2) {
    return Math.sqrt((long) (x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2));
  }
}