import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int[] V = new int[N];
    int[] P = new int[N];
    for (int i = 0; i < N; ++i) {
      V[i] = sc.nextInt();
      P[i] = sc.nextInt();
    }

    System.out.println(solve(V, P, X));

    sc.close();
  }

  static int solve(int[] V, int[] P, int X) {
    int sum = 0;
    for (int i = 0; i < V.length; ++i) {
      sum += V[i] * P[i];
      if (sum > X * 100) {
        return i + 1;
      }
    }

    return -1;
  }
}