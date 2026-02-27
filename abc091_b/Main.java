import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] s = new String[N];
    for (int i = 0; i < s.length; ++i) {
      s[i] = sc.next();
    }
    int M = sc.nextInt();
    String[] t = new String[M];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.next();
    }

    System.out.println(solve(s, t));

    sc.close();
  }

  static int solve(String[] s, String[] t) {
    Map<String, Integer> sSymbolToCount = buildSymbolToCount(s);
    Map<String, Integer> tSymbolToCount = buildSymbolToCount(t);

    return Math.max(
        0,
        sSymbolToCount.keySet().stream()
            .mapToInt(
                sSymbol -> sSymbolToCount.get(sSymbol) - tSymbolToCount.getOrDefault(sSymbol, 0))
            .max()
            .getAsInt());
  }

  static Map<String, Integer> buildSymbolToCount(String[] symbols) {
    Map<String, Integer> symbolToCount = new HashMap<>();
    for (String symbol : symbols) {
      symbolToCount.put(symbol, symbolToCount.getOrDefault(symbol, 0) + 1);
    }

    return symbolToCount;
  }
}