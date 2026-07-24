import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int D = sc.nextInt();
    int P = sc.nextInt();
    int[] F = new int[N];
    for (int i = 0; i < F.length; ++i) {
      F[i] = sc.nextInt();
    }

    System.out.println(solve(F, D, P));

    sc.close();
  }

  static long solve(int[] F, int D, int P) {
    Arrays.sort(F);

    long[] prefixSums = new long[F.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + F[i - 1];
    }

    long result = prefixSums[F.length];
    long batchCost = 0;
    int regularNum = F.length;
    do {
      batchCost += P;
      regularNum -= D;

      result = Math.min(result, batchCost + prefixSums[Math.max(0, regularNum)]);
    } while (regularNum >= 0);

    return result;
  }
}