import java.util.Arrays;
import java.util.Scanner;

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

    System.out.println(solve(X, Y));

    sc.close();
  }

  static String solve(int[] X, int[] Y) {
    int xSum = Arrays.stream(X).sum();
    int ySum = Arrays.stream(Y).sum();

    if (xSum > ySum) {
      return "Takahashi";
    }
    if (xSum < ySum) {
      return "Aoki";
    }

    return "Draw";
  }
}