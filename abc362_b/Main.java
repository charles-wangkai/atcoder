import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] x = new int[3];
    int[] y = new int[3];
    for (int i = 0; i < 3; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] x, int[] y) {
    int[] squaredDistances =
        IntStream.range(0, x.length)
            .map(
                i -> {
                  int dx = x[i] - x[(i + 1) % x.length];
                  int dy = y[i] - y[(i + 1) % y.length];

                  return dx * dx + dy * dy;
                })
            .sorted()
            .toArray();

    return squaredDistances[0] + squaredDistances[1] == squaredDistances[2];
  }
}