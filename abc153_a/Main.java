import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int A = sc.nextInt();

    System.out.println(solve(H, A));

    sc.close();
  }

  static int solve(int H, int A) {
    return Math.ceilDiv(H, A);
  }
}