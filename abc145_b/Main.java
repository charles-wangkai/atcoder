import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    return S.length() % 2 == 0
        && S.substring(0, S.length() / 2).equals(S.substring(S.length() / 2));
  }
}