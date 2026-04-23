import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int Y = sc.nextInt();

    System.out.println(solve(Y));

    sc.close();
  }

  static int solve(int Y) {
    int result = Y;
    while (result % 4 != 2) {
      ++result;
    }

    return result;
  }
}