import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int P = sc.nextInt();
    int Q = sc.nextInt();
    int[] D = new int[N];
    for (int i = 0; i < D.length; ++i) {
      D[i] = sc.nextInt();
    }

    System.out.println(solve(D, P, Q));

    sc.close();
  }

  static int solve(int[] D, int P, int Q) {
    return Math.min(P, Q + Arrays.stream(D).min().getAsInt());
  }
}