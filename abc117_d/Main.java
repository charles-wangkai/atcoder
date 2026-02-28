import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int BIT_NUM = 41;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long K = sc.nextLong();
    long[] A = new long[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextLong();
    }

    System.out.println(solve(A, K));

    sc.close();
  }

  static long solve(long[] A, long K) {
    int[][] counts = new int[2][BIT_NUM + 1];
    for (long Ai : A) {
      for (int b = 0; b < BIT_NUM; ++b) {
        ++counts[(int) ((Ai >> b) & 1)][b];
      }
    }

    long result = -1;
    long sum = 0;
    for (int b = BIT_NUM - 1; b >= 0; --b) {
      long power = 1L << b;

      if (K >= power) {
        long nextSum =
            counts[1][b] * power
                + IntStream.range(0, b)
                    .mapToLong(i -> Math.max(counts[0][i], counts[1][i]) * (1L << i))
                    .sum();
        result = Math.max(result, sum + nextSum);

        sum += counts[0][b] * power;
        K -= power;
      } else {
        sum += counts[1][b] * power;
      }
    }
    result = Math.max(result, sum);

    return result;
  }
}