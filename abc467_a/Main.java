import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();

    System.out.println(solve(H, W) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int H, int W) {
    return W * 100 * 100 >= H * H * 25;
  }
}