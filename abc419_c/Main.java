import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] R = new int[N];
    int[] C = new int[N];
    for (int i = 0; i < N; ++i) {
      R[i] = sc.nextInt();
      C[i] = sc.nextInt();
    }

    System.out.println(solve(R, C));

    sc.close();
  }

  static int solve(int[] R, int[] C) {
    return Math.max(
        Math.ceilDiv(Arrays.stream(R).max().getAsInt() - Arrays.stream(R).min().getAsInt(), 2),
        Math.ceilDiv(Arrays.stream(C).max().getAsInt() - Arrays.stream(C).min().getAsInt(), 2));
  }
}