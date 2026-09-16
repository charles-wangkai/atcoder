import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static long solve(long N) {
    return computeCost(new HashMap<>(), N);
  }

  static long computeCost(Map<Long, Long> cache, long x) {
    if (x < 2) {
      return 0;
    }

    if (!cache.containsKey(x)) {
      cache.put(x, x + computeCost(cache, x / 2) + computeCost(cache, Math.ceilDiv(x, 2)));
    }

    return cache.get(x);
  }
}