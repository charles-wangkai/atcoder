import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int N = sc.nextInt();
    int[] W = new int[N];
    for (int i = 0; i < W.length; ++i) {
      W[i] = sc.nextInt();
    }
    int Q = sc.nextInt();
    int[] P = new int[Q];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(X, W, P));

    sc.close();
  }

  static String solve(int X, int[] W, int[] P) {
    int[] result = new int[P.length];
    boolean[] attached = new boolean[W.length];
    for (int i = 0; i < result.length; ++i) {
      if (attached[P[i] - 1]) {
        attached[P[i] - 1] = false;
        X -= W[P[i] - 1];
      } else {
        attached[P[i] - 1] = true;
        X += W[P[i] - 1];
      }

      result[i] = X;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}