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

  static int solve(int[] w, int[] v, int W) {
    Map<Integer, Integer> dp = Map.of(0, 0);
    for (int i = 0; i < w.length; ++i) {
      Map<Integer, Integer> nextDp = new HashMap<>(dp);
      for (int prevV : dp.keySet()) {
        int nextV = prevV + v[i];
        int nextW = dp.get(prevV) + w[i];
        if (nextW <= W) {
          nextDp.put(nextV, Math.min(nextDp.getOrDefault(nextV, Integer.MAX_VALUE), nextW));
        }
      }

      dp = nextDp;
    }

    return dp.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();
  }
}