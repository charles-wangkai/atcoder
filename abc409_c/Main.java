import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int L = sc.nextInt();
    int[] d = new int[N - 1];
    for (int i = 0; i < d.length; ++i) {
      d[i] = sc.nextInt();
    }

    System.out.println(solve(d, L));

    sc.close();
  }

  static long solve(int[] d, int L) {
    if (L % 3 != 0) {
      return 0;
    }

    int pos = 0;
    Map<Integer, Integer> posToCount = new HashMap<>();
    posToCount.put(pos, 1);
    for (int di : d) {
      pos = (pos + di) % L;
      posToCount.put(pos, posToCount.getOrDefault(pos, 0) + 1);
    }

    return posToCount.keySet().stream()
        .mapToLong(
            p ->
                (long) posToCount.get(p)
                    * posToCount.getOrDefault(p + L / 3, 0)
                    * posToCount.getOrDefault(p + L / 3 * 2, 0))
        .sum();
  }
}