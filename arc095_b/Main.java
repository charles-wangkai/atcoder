import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    int N = Arrays.stream(a).max().getAsInt();
    int r =
        Arrays.stream(a)
            .filter(ai -> ai != N)
            .boxed()
            .max(Comparator.comparing(ai -> Math.min(ai, N - ai)))
            .get();

    return "%d %d".formatted(N, r);
  }
}