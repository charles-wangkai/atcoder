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

  static char solve(String S) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : S.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    return letterToCount.keySet().stream()
        .filter(letter -> letterToCount.get(letter) == 1)
        .findAny()
        .get();
  }
}