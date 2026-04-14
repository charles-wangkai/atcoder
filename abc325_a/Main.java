import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T));

    sc.close();
  }

  static String solve(String S, String T) {
    return "%s san".formatted(S);
  }
}