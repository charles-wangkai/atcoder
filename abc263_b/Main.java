import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] P = new int[N - 1];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(P));

    sc.close();
  }

  static int solve(int[] P) {
    int N = P.length + 1;

    int result = 0;
    int curr = N;
    while (curr != 1) {
      curr = P[curr - 2];
      ++result;
    }

    return result;
  }
}