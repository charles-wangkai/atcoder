import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(int a, int b) {
    if (a <= 0 && b >= 0) {
      return "Zero";
    }

    int negativeNum = (a >= 0) ? 0 : (Math.min(-1, b) - a + 1);

    return (negativeNum % 2 == 0) ? "Positive" : "Negative";
  }
}