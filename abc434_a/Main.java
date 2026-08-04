import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int W = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(W, B));

    sc.close();
  }

  static int solve(int W, int B) {
    return Math.ceilDiv(W * 1000 + 1, B);
  }
}