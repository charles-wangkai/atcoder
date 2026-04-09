import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    int floor = N / 5 * 5;
    int ceil = Math.ceilDiv(N, 5) * 5;

    return (N - floor <= ceil - N) ? floor : ceil;
  }
}