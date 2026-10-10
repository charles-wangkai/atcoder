import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] T = new int[N];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.nextInt();
    }

    System.out.println(solve(T));

    sc.close();
  }

  static int solve(int[] T) {
    Map<Integer, Integer> dp = Map.of(0, 0);
    for (int Ti : T) {
      Map<Integer, Integer> nextDp = new HashMap<>();
      for (int diff : dp.keySet()) {
        update(nextDp, diff + Ti, dp.get(diff) + Ti);
        update(nextDp, Math.abs(diff - Ti), dp.get(diff) + Math.max(0, Ti - diff));
      }

      dp = nextDp;
    }

    return dp.values().stream().mapToInt(Integer::intValue).min().getAsInt();
  }

  static void update(Map<Integer, Integer> dp, int diff, int maxTime) {
    dp.put(diff, Math.min(dp.getOrDefault(diff, Integer.MAX_VALUE), maxTime));
  }
}