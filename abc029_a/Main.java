import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String W = sc.next();

    System.out.println(solve(W));

    sc.close();
  }

  static String solve(String W) {
    return W + "s";
  }
}