import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int S = sc.nextInt();
    int D = sc.nextInt();
    int[] X = new int[N];
    int[] Y = new int[N];
    for (int i = 0; i < N; ++i) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }

    System.out.println(solve(X, Y, S, D) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] X, int[] Y, int S, int D) {
    return IntStream.range(0, X.length).anyMatch(i -> X[i] < S && Y[i] > D);
  }
}