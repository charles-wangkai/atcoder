import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] W = new int[N];
    int[] X = new int[N];
    for (int i = 0; i < N; ++i) {
      W[i] = sc.nextInt();
      X[i] = sc.nextInt();
    }

    System.out.println(solve(W, X));

    sc.close();
  }

  static int solve(int[] W, int[] X) {
    return IntStream.range(0, 24)
        .map(
            utcTime ->
                IntStream.range(0, X.length)
                    .filter(
                        i -> {
                          int localTime = (utcTime + X[i]) % 24;

                          return localTime >= 9 && localTime < 18;
                        })
                    .map(i -> W[i])
                    .sum())
        .max()
        .getAsInt();
  }
}