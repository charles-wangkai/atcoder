import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] c = new int[N];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }

    System.out.println(solve(c, K));

    sc.close();
  }

  static int solve(int[] c, int K) {
    Map<Integer, Integer> colorToCount = new HashMap<>();
    for (int i = 0; i < K - 1; ++i) {
      updateMap(colorToCount, c[i], 1);
    }

    int result = -1;
    for (int i = K - 1; i < c.length; ++i) {
      updateMap(colorToCount, c[i], 1);
      result = Math.max(result, colorToCount.size());
      updateMap(colorToCount, c[i - K + 1], -1);
    }

    return result;
  }

  static void updateMap(Map<Integer, Integer> colorToCount, int color, int delta) {
    colorToCount.put(color, colorToCount.getOrDefault(color, 0) + delta);
    colorToCount.remove(color, 0);
  }
}