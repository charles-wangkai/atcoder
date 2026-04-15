import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int L = sc.nextInt();
    int R = sc.nextInt();
    int[] X = new int[N];
    int[] Y = new int[N];
    for (int i = 0; i < N; ++i) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }

    System.out.println(solve(X, Y, L, R));

    sc.close();
  }

  static int solve(int[] X, int[] Y, int L, int R) {
    return (int) IntStream.range(0, X.length).filter(i -> X[i] <= L && Y[i] >= R).count();
  }
}