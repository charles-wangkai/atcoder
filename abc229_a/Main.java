import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S1 = sc.next();
    String S2 = sc.next();

    System.out.println(solve(S1, S2) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S1, String S2) {
    return !((S1.equals(".#") && S2.equals("#.")) || (S1.equals("#.") && S2.equals(".#")));
  }
}