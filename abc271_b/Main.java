import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[][] a = new int[N][];
    for (int i = 0; i < a.length; ++i) {
      int L = sc.nextInt();
      a[i] = new int[L];
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }
    int[] s = new int[Q];
    int[] t = new int[Q];
    for (int i = 0; i < Q; ++i) {
      s[i] = sc.nextInt();
      t[i] = sc.nextInt();
    }

    System.out.println(solve(a, s, t));

    sc.close();
  }

  static String solve(int[][] a, int[] s, int[] t) {
    return IntStream.range(0, s.length)
        .map(i -> a[s[i] - 1][t[i] - 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}