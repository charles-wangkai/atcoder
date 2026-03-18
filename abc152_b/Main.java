import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(a, b));

    sc.close();
  }

  static String solve(int a, int b) {
    String s1 = String.valueOf(a).repeat(b);
    String s2 = String.valueOf(b).repeat(a);

    return (s1.compareTo(s2) < 0) ? s1 : s2;
  }
}