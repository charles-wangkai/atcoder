import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] p = new int[N];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }

    System.out.println("%.9f".formatted(solve(p, K)));

    sc.close();
  }

  static double solve(int[] p, int K) {
    int[] prefixSums = new int[p.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + p[i - 1];
    }

    return (IntStream.rangeClosed(0, p.length - K)
                .map(i -> prefixSums[i + K] - prefixSums[i])
                .max()
                .getAsInt()
            + K)
        / 2.0;
  }
}