import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(a, b) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int a, int b) {
    int value = Integer.parseInt("%d%d".formatted(a, b));
    int root = (int) Math.round(Math.sqrt(value));

    return root * root == value;
  }
}