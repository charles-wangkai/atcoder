import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();
    int Z = sc.nextInt();

    System.out.println(solve(X, Y, Z));

    sc.close();
  }

  static int solve(int X, int Y, int Z) {
    if (Integer.signum(-Y) == Integer.signum(X - Y)) {
      return Math.abs(X);
    }
    if (Integer.signum(-Y) != Integer.signum(Z - Y)) {
      return -1;
    }
    if (Integer.signum(-Z) != Integer.signum(X - Z)) {
      return Math.abs(X);
    }

    return Math.abs(Z) + Math.abs(Z - X);
  }
}