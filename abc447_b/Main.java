import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : S.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    int maxCount = letterToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt();

    return S.chars()
        .mapToObj(c -> (char) c)
        .filter(letter -> letterToCount.get(letter) != maxCount)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}