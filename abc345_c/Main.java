import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static long solve(String S) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : S.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    return S.length() * (S.length() - 1L) / 2
        - letterToCount.values().stream().mapToLong(count -> count * (count - 1L) / 2).sum()
        + ((letterToCount.values().stream().anyMatch(count -> count >= 2)) ? 1 : 0);
  }
}