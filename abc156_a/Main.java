import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int R = sc.nextInt();

    System.out.println(solve(N, R));

    sc.close();
  }

  static int solve(int N, int R) {
    return R + 100 * Math.max(0, 10 - N);
  }
}