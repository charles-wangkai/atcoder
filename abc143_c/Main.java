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
        IntStream.range(0, S.length())
            .filter(i -> i == 0 || S.charAt(i) != S.charAt(i - 1))
            .count();
  }
}