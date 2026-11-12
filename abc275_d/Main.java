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
    return f(new HashMap<Long, Long>(), N);
  }

  static long f(Map<Long, Long> cache, long x) {
    if (x == 0) {
      return 1;
    }

    if (!cache.containsKey(x)) {
      cache.put(x, f(cache, x / 2) + f(cache, x / 3));
    }

    return cache.get(x);
  }
}