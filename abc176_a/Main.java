import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int T = sc.nextInt();

    System.out.println(solve(N, X, T));

    sc.close();
  }

  static int solve(int N, int X, int T) {
    return Math.ceilDiv(N, X) * T;
  }
}