import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    return 1
        + (int) S.chars().filter(c -> c == '+').count()
        - (int) S.chars().filter(c -> c == '-').count();
  }
}