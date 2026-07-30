import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int[] a = new int[N];
    int[] b = new int[N];
    for (int i = 0; i < N; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, X) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] a, int[] b, int X) {
    Set<Integer> dp = Set.of(0);
    for (int i = 0; i < a.length; ++i) {
      int i_ = i;
      dp = dp.stream().flatMap(x -> Stream.of(x + a[i_], x + b[i_])).collect(Collectors.toSet());
    }

    return dp.contains(X);
  }
}