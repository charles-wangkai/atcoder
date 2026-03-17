import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T));

    sc.close();
  }

  static int solve(String S, String T) {
    return (int) IntStream.range(0, S.length()).filter(i -> S.charAt(i) == T.charAt(i)).count();
  }
}