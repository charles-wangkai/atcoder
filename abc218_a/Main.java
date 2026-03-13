import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(N, S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N, String S) {
    return S.charAt(N - 1) == 'o';
  }
}