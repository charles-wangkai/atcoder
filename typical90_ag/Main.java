import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();

    System.out.println(solve(H, W));

    sc.close();
  }

  static int solve(int H, int W) {
    if (H == 1 || W == 1) {
      return H * W;
    }

    return Math.ceilDiv(H, 2) * Math.ceilDiv(W, 2);
  }
}