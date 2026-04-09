import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int L = sc.nextInt();
    int R = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, L, R) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S, int L, int R) {
    return IntStream.rangeClosed(L - 1, R - 1).allMatch(i -> S.charAt(i) == 'o');
  }
}