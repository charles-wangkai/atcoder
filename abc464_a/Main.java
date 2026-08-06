import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    return (S.chars().filter(c -> c == 'E').count() > S.chars().filter(c -> c == 'W').count())
        ? "East"
        : "West";
  }
}