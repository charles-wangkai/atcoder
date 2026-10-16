import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      int N = sc.nextInt();
      int[] W = new int[N];
      int[] P = new int[N];
      for (int i = 0; i < N; ++i) {
        W[i] = sc.nextInt();
        P[i] = sc.nextInt();
      }

      System.out.println(solve(W, P));
    }

    sc.close();
  }

  static int solve(int[] W, int[] P) {
    long diff = Arrays.stream(P).asLongStream().sum();

    int[] deltas = IntStream.range(0, W.length).map(i -> W[i] + P[i]).sorted().toArray();

    int result = 0;
    for (int delta : deltas) {
      if (diff < delta) {
        break;
      }

      diff -= delta;
      ++result;
    }

    return result;
  }
}