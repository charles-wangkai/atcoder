import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    int[] P = new int[N];
    int[] X = new int[N];
    for (int i = 0; i < N; ++i) {
      A[i] = sc.nextInt();
      P[i] = sc.nextInt();
      X[i] = sc.nextInt();
    }

    System.out.println(solve(A, P, X));

    sc.close();
  }

  static int solve(int[] A, int[] P, int[] X) {
    return IntStream.range(0, A.length).filter(i -> A[i] < X[i]).map(i -> P[i]).min().orElse(-1);
  }
}