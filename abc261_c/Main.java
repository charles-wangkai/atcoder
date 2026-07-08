import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

  static String solve(String[] S) {
    String[] result = new String[S.length];
    Map<String, Integer> stringToCount = new HashMap<>();
    for (int i = 0; i < result.length; ++i) {
      result[i] =
          stringToCount.containsKey(S[i])
              ? "%s(%d)".formatted(S[i], stringToCount.get(S[i]))
              : S[i];

      stringToCount.put(S[i], stringToCount.getOrDefault(S[i], 0) + 1);
    }

    return String.join("\n", result);
  }
}