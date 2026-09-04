import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int K = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, K));

    sc.close();
  }

  static String solve(String S, int K) {
    Map<String, Integer> substrToCount = new HashMap<>();
    for (int i = 0; i <= S.length() - K; ++i) {
      String substr = S.substring(i, i + K);
      substrToCount.put(substr, substrToCount.getOrDefault(substr, 0) + 1);
    }

    int maxCount = substrToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt();

    return "%d\n%s"
        .formatted(
            maxCount,
            substrToCount.keySet().stream()
                .filter(substr -> substrToCount.get(substr) == maxCount)
                .sorted()
                .collect(Collectors.joining(" ")));
  }
}