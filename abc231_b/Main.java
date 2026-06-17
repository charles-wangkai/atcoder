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
    Map<String, Integer> nameToCount = new HashMap<>();
    for (String Si : S) {
      nameToCount.put(Si, nameToCount.getOrDefault(Si, 0) + 1);
    }

    int maxCount = nameToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt();

    return nameToCount.keySet().stream()
        .filter(name -> nameToCount.get(name) == maxCount)
        .findAny()
        .get();
  }
}