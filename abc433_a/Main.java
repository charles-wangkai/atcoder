import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();
    int Z = sc.nextInt();

    System.out.println(solve(X, Y, Z) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int X, int Y, int Z) {
    int product = X - Z * Y;
    int factor = Z - 1;

    return product >= 0 && product % factor == 0;
  }
}