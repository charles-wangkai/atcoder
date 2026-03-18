import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();
    int A = sc.nextInt();
    int B = sc.nextInt();
    String U = sc.next();

    System.out.println(solve(S, T, A, B, U));

    sc.close();
  }

  static String solve(String S, String T, int A, int B, String U) {
    if (U.equals(S)) {
      --A;
    } else {
      --B;
    }

    return "%d %d".formatted(A, B);
  }
}