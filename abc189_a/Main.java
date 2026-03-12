import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    System.out.println(solve(s) ? "Won" : "Lost");

    sc.close();
  }

  static boolean solve(String s) {
    return s.chars().distinct().count() == 1;
  }
}