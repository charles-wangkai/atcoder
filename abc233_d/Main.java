import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long K = sc.nextLong();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, K));

    sc.close();
  }

  static long solve(int[] A, long K) {
    Map<Long, Integer> prefixSumToCount = new HashMap<>();
    prefixSumToCount.put(0L, 1);

    long result = 0;
    long sum = 0;
    for (int Ai : A) {
      sum += Ai;
      result += prefixSumToCount.getOrDefault(sum - K, 0);
      prefixSumToCount.put(sum, prefixSumToCount.getOrDefault(sum, 0) + 1);
    }

    return result;
  }
}