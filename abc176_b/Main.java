import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String N = sc.next();

    System.out.println(solve(N) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String N) {
    return N.chars().map(c -> c - '0').sum() % 9 == 0;
  }
}