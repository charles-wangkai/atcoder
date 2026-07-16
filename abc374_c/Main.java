import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] K = new int[N];
    for (int i = 0; i < K.length; ++i) {
      K[i] = sc.nextInt();
    }

    System.out.println(solve(K));

    sc.close();
  }

  static int solve(int[] K) {
    return IntStream.range(0, 1 << K.length)
        .map(
            mask -> {
              int[] sums = new int[2];
              for (int i = 0; i < K.length; ++i) {
                sums[(mask >> i) & 1] += K[i];
              }

              return Math.max(sums[0], sums[1]);
            })
        .min()
        .getAsInt();
  }
}