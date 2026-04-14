import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int n) {
    if (n >= 63) {
      return true;
    }

    return (1L << n) > n * n;
  }
}