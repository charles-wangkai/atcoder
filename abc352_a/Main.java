import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();
    int Z = sc.nextInt();

    System.out.println(solve(N, X, Y, Z) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N, int X, int Y, int Z) {
    return (Z - X) * (Z - Y) < 0;
  }
}