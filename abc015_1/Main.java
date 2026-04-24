import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String A = sc.next();
    String B = sc.next();

    System.out.println(solve(A, B));

    sc.close();
  }

  static String solve(String A, String B) {
    return (A.length() > B.length()) ? A : B;
  }
}