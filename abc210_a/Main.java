import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int A = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();

    System.out.println(solve(N, A, X, Y));

    sc.close();
  }

  static int solve(int N, int A, int X, int Y) {
    return Math.min(A, N) * X + Math.max(0, N - A) * Y;
  }
}