import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int T = sc.nextInt();
    int[] C = new int[N];
    for (int i = 0; i < C.length; ++i) {
      C[i] = sc.nextInt();
    }
    int[] R = new int[N];
    for (int i = 0; i < R.length; ++i) {
      R[i] = sc.nextInt();
    }

    System.out.println(solve(C, R, T));

    sc.close();
  }

  static int solve(int[] C, int[] R, int T) {
    int color = Arrays.stream(C).anyMatch(Ci -> Ci == T) ? T : C[0];

    return IntStream.range(0, C.length)
            .filter(i -> C[i] == color)
            .boxed()
            .max(Comparator.comparing(i -> R[i]))
            .get()
        + 1;
  }
}