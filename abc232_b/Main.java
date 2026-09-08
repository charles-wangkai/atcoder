import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S, String T) {
    return IntStream.range(0, S.length())
            .map(i -> Math.floorMod(S.charAt(i) - T.charAt(i), 26))
            .distinct()
            .count()
        == 1;
  }
}