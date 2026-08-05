import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int C = sc.nextInt();

    System.out.println(solve(X, C));

    sc.close();
  }

  static int solve(int X, int C) {
    int current = 0;
    while (true) {
      int next = current + 1000;
      if (next + next / 1000 * C > X) {
        return current;
      }

      current = next;
    }
  }
}