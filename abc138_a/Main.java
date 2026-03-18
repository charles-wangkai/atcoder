import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    String s = sc.next();

    System.out.println(solve(a, s));

    sc.close();
  }

  static String solve(int a, String s) {
    return (a >= 3200) ? s : "red";
  }
}