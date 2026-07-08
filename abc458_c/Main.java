import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static long solve(String S) {
    return IntStream.range(0, S.length())
        .filter(i -> S.charAt(i) == 'C')
        .map(i -> Math.min(i + 1, S.length() - i))
        .asLongStream()
        .sum();
  }
}