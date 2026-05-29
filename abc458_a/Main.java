import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    int N = sc.nextInt();

    System.out.println(solve(S, N));

    sc.close();
  }

  static String solve(String S, int N) {
    return S.substring(N, S.length() - N);
  }
}