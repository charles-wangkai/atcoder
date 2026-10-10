import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S, String T) {
    return (S.length() == T.length()
            && IntStream.range(0, S.length()).filter(i -> S.charAt(i) != T.charAt(i)).count() <= 1)
        || (S.length() + 1 == T.length() && canInsertOne(S, T))
        || (T.length() + 1 == S.length() && canInsertOne(T, S));
  }

  static boolean canInsertOne(String str, String target) {
    return computeSamePrefixLength(str, target)
            + computeSamePrefixLength(reverse(str), reverse(target))
        >= str.length();
  }

  static int computeSamePrefixLength(String s1, String s2) {
    int result = 0;
    while (result != s1.length()
        && result != s2.length()
        && s1.charAt(result) == s2.charAt(result)) {
      ++result;
    }

    return result;
  }

  static String reverse(String str) {
    return new StringBuilder(str).reverse().toString();
  }
}