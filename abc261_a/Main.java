import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int L1 = sc.nextInt();
    int R1 = sc.nextInt();
    int L2 = sc.nextInt();
    int R2 = sc.nextInt();

    System.out.println(solve(L1, R1, L2, R2));

    sc.close();
  }

  static int solve(int L1, int R1, int L2, int R2) {
    return Math.max(0, Math.min(R1, R2) - Math.max(L1, L2));
  }
}