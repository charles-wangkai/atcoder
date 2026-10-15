import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final String TARGET = "atcoder";
  static final Map<Character, Integer> LETTER_TO_TARGET_INDEX =
      IntStream.range(0, TARGET.length()).boxed().collect(Collectors.toMap(TARGET::charAt, i -> i));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    int result = 0;
    for (int i = 0; i < S.length(); ++i) {
      for (int j = i + 1; j < S.length(); ++j) {
        if (LETTER_TO_TARGET_INDEX.get(S.charAt(i)) > LETTER_TO_TARGET_INDEX.get(S.charAt(j))) {
          ++result;
        }
      }
    }

    return result;
  }
}