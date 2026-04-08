import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Weak" : "Strong");

    sc.close();
  }

  static boolean solve(String S) {
    return S.chars().distinct().count() == 1
        || IntStream.range(0, S.length() - 1)
            .allMatch(i -> (S.charAt(i) - '0' + 1) % 10 == S.charAt(i + 1) - '0');
  }
}