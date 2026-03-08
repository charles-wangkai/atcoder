import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(x, a, b));

    sc.close();
  }

  static String solve(int x, int a, int b) {
    StringBuilder result = new StringBuilder();

    int value = x + 1;
    result.append(value);

    value *= a + b;
    result.append("\n").append(value);

    value *= value;
    result.append("\n").append(value);

    --value;
    result.append("\n").append(value);

    return result.toString();
  }
}