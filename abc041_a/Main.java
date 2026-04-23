import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();
    int i = sc.nextInt();

    System.out.println(solve(s, i));

    sc.close();
  }

  static char solve(String s, int i) {
    return s.charAt(i - 1);
  }
}