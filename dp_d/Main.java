import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int W = sc.nextInt();
    int[] w = new int[N];
    int[] v = new int[N];
    for (int i = 0; i < N; ++i) {
      w[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(w, v, W));

    sc.close();
  }

  static long solve(int[] w, int[] v, int W) {
    Map<Integer, Long> dp = Map.of(0, 0L);
    for (int i = 0; i < w.length; ++i) {
      Map<Integer, Long> nextDp = new HashMap<>(dp);
      for (int prevW : dp.keySet()) {
        int nextW = prevW + w[i];
        if (nextW <= W) {
          nextDp.put(nextW, Math.max(nextDp.getOrDefault(nextW, 0L), dp.get(prevW) + v[i]));
        }
      }

      dp = nextDp;
    }

    return dp.values().stream().mapToLong(Long::longValue).max().getAsLong();
  }
}