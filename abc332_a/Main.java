import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int S = sc.nextInt();
    int K = sc.nextInt();
    int[] P = new int[N];
    int[] Q = new int[N];
    for (int i = 0; i < N; ++i) {
      P[i] = sc.nextInt();
      Q[i] = sc.nextInt();
    }

    System.out.println(solve(P, Q, S, K));

    sc.close();
  }

  static int solve(int[] P, int[] Q, int S, int K) {
    int result = IntStream.range(0, P.length).map(i -> P[i] * Q[i]).sum();
    if (result < S) {
      result += K;
    }

    return result;
  }
}