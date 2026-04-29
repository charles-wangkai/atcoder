import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static long solve(int[] A) {
    long minDelta = 0;
    long delta = 0;
    for (int Ai : A) {
      delta += Ai;
      minDelta = Math.min(minDelta, delta);
    }

    return -minDelta + delta;
  }
}