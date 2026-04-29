import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] T = new int[N];
    int[] V = new int[N];
    for (int i = 0; i < N; ++i) {
      T[i] = sc.nextInt();
      V[i] = sc.nextInt();
    }

    System.out.println(solve(T, V));

    sc.close();
  }

  static int solve(int[] T, int[] V) {
    int result = 0;
    for (int i = 0; i < T.length; ++i) {
      result = Math.max(0, result - (T[i] - ((i == 0) ? 0 : T[i - 1])));
      result += V[i];
    }

    return result;
  }
}