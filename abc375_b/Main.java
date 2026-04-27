import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] X = new int[N];
    int[] Y = new int[N];
    for (int i = 0; i < N; ++i) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }

    System.out.println("%.9f".formatted(solve(X, Y)));

    sc.close();
  }

  static double solve(int[] X, int[] Y) {
    int N = X.length;

    return computeDistance(0, 0, X[0], Y[0])
        + IntStream.range(0, N - 1)
            .mapToDouble(i -> computeDistance(X[i], Y[i], X[i + 1], Y[i + 1]))
            .sum()
        + computeDistance(X[N - 1], Y[N - 1], 0, 0);
  }

  static double computeDistance(int x1, int y1, int x2, int y2) {
    return Math.sqrt((long) (x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2));
  }
}