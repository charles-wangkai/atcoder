import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(x, y));

    sc.close();
  }

  static int solve(int x, int y) {
    return (x == y) ? x : (3 - x - y);
  }
}