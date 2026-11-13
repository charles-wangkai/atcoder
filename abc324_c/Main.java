import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String TPrime = sc.next();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S, TPrime));

    sc.close();
  }

  static String solve(String[] S, String TPrime) {
    int[] indices = IntStream.range(0, S.length).filter(i -> check(TPrime, S[i])).toArray();

    return "%d\n%s"
        .formatted(
            indices.length,
            Arrays.stream(indices)
                .map(index -> index + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }

  static boolean check(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return check(s2, s1);
    }
    if (s1.length() == s2.length()) {
      return IntStream.range(0, s1.length()).filter(i -> s1.charAt(i) != s2.charAt(i)).count() <= 1;
    }
    if (s1.length() + 1 == s2.length()) {
      return computePrefixMatchedNum(s1, s2) + computePrefixMatchedNum(reverse(s1), reverse(s2))
          >= s2.length() - 1;
    }

    return false;
  }

  static int computePrefixMatchedNum(String s1, String s2) {
    for (int i = 0; ; ++i) {
      if (i == s1.length() || s1.charAt(i) != s2.charAt(i)) {
        return i;
      }
    }
  }

  static String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
  }
}