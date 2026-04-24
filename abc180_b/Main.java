import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] x = new int[N];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }

    System.out.println(solve(x));

    sc.close();
  }

  static String solve(int[] x) {
    return "%d\n%.9f\n%d"
        .formatted(
            Arrays.stream(x).map(Math::abs).asLongStream().sum(),
            Math.sqrt(Arrays.stream(x).mapToLong(xi -> (long) xi * xi).sum()),
            Arrays.stream(x).map(Math::abs).max().getAsInt());
  }
}