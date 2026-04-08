import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S, String T) {
    return isAdjacent(S.charAt(0), S.charAt(1)) == isAdjacent(T.charAt(0), T.charAt(1));
  }

  static boolean isAdjacent(char letter1, char letter2) {
    return Math.abs(letter1 - letter2) == 1 || Math.abs(letter1 - letter2) == 4;
  }
}