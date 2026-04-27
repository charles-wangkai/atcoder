import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    return IntStream.range(0, S.length())
            .filter(i -> Character.isUpperCase(S.charAt(i)))
            .findAny()
            .getAsInt()
        + 1;
  }
}