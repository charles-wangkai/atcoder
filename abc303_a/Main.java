import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S, String T) {
    return IntStream.range(0, S.length()).allMatch(i -> isSimilar(S.charAt(i), T.charAt(i)));
  }

  static boolean isSimilar(char c1, char c2) {
    return c1 == c2
        || (c1 == '1' && c2 == 'l')
        || (c1 == 'l' && c2 == '1')
        || (c1 == '0' && c2 == 'o')
        || (c1 == 'o' && c2 == '0');
  }
}