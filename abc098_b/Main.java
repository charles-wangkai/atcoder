import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    return IntStream.range(0, S.length())
        .map(
            endIndex ->
                (int)
                    IntStream.rangeClosed('a', 'z')
                        .filter(
                            c ->
                                S.substring(0, endIndex).indexOf(c) >= 0
                                    && S.substring(endIndex).indexOf(c) >= 0)
                        .count())
        .max()
        .getAsInt();
  }
}