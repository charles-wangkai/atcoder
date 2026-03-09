import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    double[] p = new double[N];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextDouble();
    }

    System.out.println("%.9f".formatted(solve(p)));

    sc.close();
  }

  static double solve(double[] p) {
    Map<Integer, Double> dp = Map.of(0, 1.0);
    for (double pi : p) {
      Map<Integer, Double> nextDp = new HashMap<>();
      for (int diff : dp.keySet()) {
        nextDp.put(diff + 1, nextDp.getOrDefault(diff + 1, 0.0) + dp.get(diff) * pi);
        nextDp.put(diff - 1, nextDp.getOrDefault(diff - 1, 0.0) + dp.get(diff) * (1 - pi));
      }

      dp = nextDp;
    }

    return dp.keySet().stream().filter(diff -> diff > 0).mapToDouble(dp::get).sum();
  }
}