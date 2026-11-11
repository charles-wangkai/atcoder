import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] x = new int[N];
    int[] y = new int[N];
    for (int i = 0; i < N; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y));

    sc.close();
  }

  static int solve(int[] x, int[] y) {
    Set<Point> points =
        IntStream.range(0, x.length)
            .mapToObj(i -> new Point(x[i], y[i]))
            .collect(Collectors.toSet());

    int result = 0;
    for (int i = 0; i < x.length; ++i) {
      for (int j = 0; j < x.length; ++j) {
        if (x[j] > x[i]
            && y[j] > y[i]
            && points.contains(new Point(x[i], y[j]))
            && points.contains(new Point(x[j], y[i]))) {
          ++result;
        }
      }
    }

    return result;
  }
}

record Point(int x, int y) {}
