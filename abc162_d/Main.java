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

  static long solve(String S) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (char letter : S.toCharArray()) {
      letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
    }

    long result =
        (long) letterToCount.getOrDefault('R', 0)
            * letterToCount.getOrDefault('G', 0)
            * letterToCount.getOrDefault('B', 0);

    for (int i = 0; i < S.length(); ++i) {
      for (int j = i + 1; j < S.length(); ++j) {
        int k = j + (j - i);
        if (k < S.length()
            && S.charAt(i) != S.charAt(j)
            && S.charAt(j) != S.charAt(k)
            && S.charAt(k) != S.charAt(i)) {
          --result;
        }
      }
    }

    return result;
  }
}