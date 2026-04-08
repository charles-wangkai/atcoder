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
    return (int)
        IntStream.range(0, S.length() - 2)
            .filter(i -> S.charAt(i) == '#' && S.charAt(i + 1) == '.' && S.charAt(i + 2) == '#')
            .count();
  }
}