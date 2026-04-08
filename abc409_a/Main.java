import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String T = sc.next();
    String A = sc.next();

    System.out.println(solve(T, A) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String T, String A) {
    return IntStream.range(0, T.length()).anyMatch(i -> T.charAt(i) == 'o' && A.charAt(i) == 'o');
  }
}