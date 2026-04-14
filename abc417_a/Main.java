import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, A, B));

    sc.close();
  }

  static String solve(String S, int A, int B) {
    return S.substring(A, S.length() - B);
  }
}