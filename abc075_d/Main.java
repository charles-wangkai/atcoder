import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] x = new int[N];
    int[] y = new int[N];
    for (int i = 0; i < N; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y, K));

    sc.close();
  }

  static long solve(int[] x, int[] y, int K) {
    long result = Long.MAX_VALUE;
    for (int minX : x) {
      for (int maxX : x) {
        for (int minY : y) {
          for (int maxY : y) {
            if (IntStream.range(0, x.length)
                    .filter(i -> x[i] >= minX && x[i] <= maxX && y[i] >= minY && y[i] <= maxY)
                    .count()
                >= K) {
              result = Math.min(result, (long) (maxX - minX) * (maxY - minY));
            }
          }
        }
      }
    }

    return result;
  }
}