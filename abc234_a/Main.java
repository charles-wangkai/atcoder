import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();

    System.out.println(solve(t));

    sc.close();
  }

  static int solve(int t) {
    return f(f(f(t) + t) + f(f(t)));
  }

  static int f(int x) {
    return x * x + 2 * x + 3;
  }
}