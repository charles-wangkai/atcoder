import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] X = new int[N];
      int[] Y = new int[N];
      for (int i = 0; i < N; ++i) {
        X[i] = sc.nextInt();
        Y[i] = sc.nextInt();
      }

      System.out.println(solve(X, Y));
    }
  }

  static long solve(int[] X, int[] Y) {
    Map<Boolean, Long> dp = Map.of(true, 0L);
    for (int i = 0; i < X.length; ++i) {
      Map<Boolean, Long> nextDp = new HashMap<>(dp);
      for (boolean healthy : dp.keySet()) {
        if (healthy || X[i] == 0) {
          boolean nextHealthy = X[i] == 0;

          nextDp.put(
              nextHealthy,
              Math.max(nextDp.getOrDefault(nextHealthy, Long.MIN_VALUE), dp.get(healthy) + Y[i]));
        }
      }

      dp = nextDp;
    }

    return dp.values().stream().mapToLong(Long::longValue).max().getAsLong();
  }
}