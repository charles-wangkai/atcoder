import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int N = sc.nextInt();
    int[] p = new int[N];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }

    System.out.println(solve(X, p));

    sc.close();
  }

  static int solve(int X, int[] p) {
    Set<Integer> set = Arrays.stream(p).boxed().collect(Collectors.toSet());
    for (int d = 0; ; ++d) {
      for (int sign : new int[] {-1, 1}) {
        int value = X + sign * d;
        if (!set.contains(value)) {
          return value;
        }
      }
    }
  }
}