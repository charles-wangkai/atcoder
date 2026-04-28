import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(N, S));

    sc.close();
  }

  static String solve(int N, String S) {
    return "o".repeat(N - S.length()) + S;
  }
}