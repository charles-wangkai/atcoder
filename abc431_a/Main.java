import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(H, B));

    sc.close();
  }

  static int solve(int H, int B) {
    return Math.max(0, H - B);
  }
}