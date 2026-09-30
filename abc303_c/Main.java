import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int M = sc.nextInt();
    int H = sc.nextInt();
    int K = sc.nextInt();
    String S = sc.next();
    int[] x = new int[M];
    int[] y = new int[M];
    for (int i = 0; i < M; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(S, x, y, H, K) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S, int[] x, int[] y, int H, int K) {
    Set<Point> items =
        IntStream.range(0, x.length)
            .mapToObj(i -> new Point(x[i], y[i]))
            .collect(Collectors.toSet());

    int currX = 0;
    int currY = 0;
    for (char move : S.toCharArray()) {
      if (H == 0) {
        return false;
      }

      if (move == 'R') {
        ++currX;
      } else if (move == 'L') {
        --currX;
      } else if (move == 'U') {
        ++currY;
      } else {
        --currY;
      }

      --H;

      Point point = new Point(currX, currY);
      if (items.contains(point) && H < K) {
        H = K;
        items.remove(point);
      }
    }

    return true;
  }
}

record Point(int x, int y) {}
