import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char alpha = sc.next().charAt(0);

    System.out.println(solve(alpha));

    sc.close();
  }

  static String solve(char alpha) {
    return Character.isUpperCase(alpha) ? "A" : "a";
  }
}
