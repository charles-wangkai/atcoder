import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();

    System.out.println(solve(X, Y) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int X, int Y) {
    return X * 9 == Y * 16;
  }
}