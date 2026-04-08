import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] x = new int[3];
    int[] y = new int[3];
    for (int i = 0; i < 3; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y));

    sc.close();
  }

  static String solve(int[] x, int[] y) {
    return "%d %d"
        .formatted(
            Arrays.stream(x).reduce(0, (acc, a) -> acc ^ a),
            Arrays.stream(y).reduce(0, (acc, a) -> acc ^ a));
  }
}