import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    Map<Character, Integer> letterToMaxLength = new HashMap<>();
    int length = 0;
    for (int i = 0; i < S.length(); ++i) {
      char letter = S.charAt(i);

      if (i == 0 || letter != S.charAt(i - 1)) {
        length = 0;
      }
      ++length;

      letterToMaxLength.put(letter, Math.max(letterToMaxLength.getOrDefault(letter, -1), length));
    }

    return letterToMaxLength.values().stream().mapToInt(Integer::intValue).sum();
  }
}