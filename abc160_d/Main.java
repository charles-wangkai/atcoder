import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();

    System.out.println(solve(N, X, Y));

    sc.close();
  }

  static String solve(int N, int X, int Y) {
    int[] counts = new int[N];
    for (int i = 1; i <= N; ++i) {
      for (int j = i + 1; j <= N; ++j) {
        ++counts[computeDistance(X, Y, i, j)];
      }
    }

    return IntStream.rangeClosed(1, N - 1)
        .map(i -> counts[i])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int computeDistance(int X, int Y, int u, int v) {
    return Math.min(v - u, Math.abs(u - X) + 1 + Math.abs(v - Y));
  }
}