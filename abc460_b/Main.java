import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      int X1 = sc.nextInt();
      int Y1 = sc.nextInt();
      int R1 = sc.nextInt();
      int X2 = sc.nextInt();
      int Y2 = sc.nextInt();
      int R2 = sc.nextInt();

      System.out.println(solve(X1, Y1, R1, X2, Y2, R2) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int X1, int Y1, int R1, int X2, int Y2, int R2) {
    return square(X1 - X2) + square(Y1 - Y2) <= square(R1 + R2)
        && square(X1 - X2) + square(Y1 - Y2) >= square(R1 - R2);
  }

  static long square(int x) {
    return (long) x * x;
  }
}