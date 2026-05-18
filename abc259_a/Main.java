import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int X = sc.nextInt();
    int T = sc.nextInt();
    int D = sc.nextInt();

    System.out.println(solve(N, M, X, T, D));

    sc.close();
  }

  static int solve(int N, int M, int X, int T, int D) {
    return T - D * Math.max(0, X - M);
  }
}