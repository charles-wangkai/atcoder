import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main {
  static Set<String> WORDS = Set.of("and", "not", "that", "the", "you");

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] W = new String[N];
    for (int i = 0; i < W.length; ++i) {
      W[i] = sc.next();
    }

    System.out.println(solve(W) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String[] W) {
    return Arrays.stream(W).anyMatch(WORDS::contains);
  }
}