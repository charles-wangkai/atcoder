import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] t = new int[N];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }
    int[] v = new int[N];
    for (int i = 0; i < v.length; ++i) {
      v[i] = sc.nextInt();
    }

    System.out.println("%.9f".formatted(solve(t, v)));

    sc.close();
  }

  static double solve(int[] t, int[] v) {
    int N = t.length;

    int[] leftMaxs = new int[N - 1];
    for (int i = 0; i < leftMaxs.length; ++i) {
      leftMaxs[i] = Math.min(Math.min(((i == 0) ? 0 : leftMaxs[i - 1]) + t[i], v[i]), v[i + 1]);
    }

    int[] rightMaxs = new int[N - 1];
    for (int i = rightMaxs.length - 1; i >= 0; --i) {
      rightMaxs[i] =
          Math.min(
              Math.min(((i == rightMaxs.length - 1) ? 0 : rightMaxs[i + 1]) + t[i + 1], v[i + 1]),
              v[i]);
    }

    int[] maxs = IntStream.range(0, N - 1).map(i -> Math.min(leftMaxs[i], rightMaxs[i])).toArray();

    return IntStream.range(0, N)
        .mapToDouble(
            i ->
                computeMaxDistance(
                    t[i], v[i], (i == 0) ? 0 : maxs[i - 1], (i == N - 1) ? 0 : maxs[i]))
        .sum();
  }

  static double computeMaxDistance(int time, int limitV, int v1, int v2) {
    double maxV;
    if ((limitV - v1) + (limitV - v2) <= time) {
      maxV = limitV;
    } else {
      maxV = (time + v1 + v2) / 2.0;
    }

    return (v1 + maxV) * (maxV - v1) / 2
        + maxV * (time - (maxV - v1) - (maxV - v2))
        + (maxV + v2) * (maxV - v2) / 2;
  }
}