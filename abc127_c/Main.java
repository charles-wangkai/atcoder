import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] L = new int[M];
    int[] R = new int[M];
    for (int i = 0; i < M; ++i) {
      L[i] = sc.nextInt();
      R[i] = sc.nextInt();
    }

    System.out.println(solve(N, L, R));

    sc.close();
  }

  static int solve(int N, int[] L, int[] R) {
    return Math.max(0, Arrays.stream(R).min().getAsInt() - Arrays.stream(L).max().getAsInt() + 1);
  }
}