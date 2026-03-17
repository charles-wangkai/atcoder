import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    int withTax = N * 108 / 100;

    if (withTax < 206) {
      return "Yay!";
    }
    if (withTax > 206) {
      return ":(";
    }

    return "so-so";
  }
}