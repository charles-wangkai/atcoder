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
    return (int)
        IntStream.range(0, 10000)
            .filter(
                x -> {
                  String str = String.format("%04d", x);

                  return IntStream.range(0, S.length())
                      .allMatch(
                          i ->
                              (S.charAt(i) == 'o' && str.indexOf(i + '0') != -1)
                                  || (S.charAt(i) == 'x' && str.indexOf(i + '0') == -1)
                                  || S.charAt(i) == '?');
                })
            .count();
  }
}