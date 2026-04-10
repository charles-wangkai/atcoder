import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();

    System.out.println(solve(H, W));

    sc.close();
  }

  static long solve(int H, int W) {
    return (H == 1 || W == 1) ? 1 : (((long) H * W + 1) / 2);
  }
}