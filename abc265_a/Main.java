import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();
    int N = sc.nextInt();

    System.out.println(solve(X, Y, N));

    sc.close();
  }

  static int solve(int X, int Y, int N) {
    return Math.min(X * N, Y * (N / 3) + X * (N % 3));
  }
}