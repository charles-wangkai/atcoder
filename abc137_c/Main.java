import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S));

    sc.close();
  }

  static long solve(String[] S) {
    Map<String, Integer> keyToCount = new HashMap<>();
    for (String Si : S) {
      String key = buildKey(Si);
      keyToCount.put(key, keyToCount.getOrDefault(key, 0) + 1);
    }

    return keyToCount.values().stream().mapToLong(count -> count * (count - 1L) / 2).sum();
  }

  static String buildKey(String str) {
    return str.chars()
        .mapToObj(c -> (char) c)
        .sorted()
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}