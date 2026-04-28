import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String P = sc.next();
    int L = sc.nextInt();

    System.out.println(solve(P, L) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String P, int L) {
    return P.length() >= L;
  }
}