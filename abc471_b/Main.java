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

  static int solve(String[] S) {
    Map<String, Integer> answerToCount = new HashMap<>();
    for (String Si : S) {
      answerToCount.put(Si.toLowerCase(), answerToCount.getOrDefault(Si.toLowerCase(), 0) + 1);
    }

    return answerToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt();
  }
}