import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S, K));

    sc.close();
  }

  static int solve(String[] S, int K) {
    return IntStream.range(0, 1 << S.length)
        .map(mask -> computeLetterNum(S, K, mask))
        .max()
        .getAsInt();
  }

  static int computeLetterNum(String[] S, int K, int mask) {
    Map<Character, Integer> letterToCount = new HashMap<>();
    for (int i = 0; i < S.length; ++i) {
      if (((mask >> i) & 1) == 1) {
        for (char letter : S[i].toCharArray()) {
          letterToCount.put(letter, letterToCount.getOrDefault(letter, 0) + 1);
        }
      }
    }

    return (int) letterToCount.values().stream().filter(count -> count == K).count();
  }
}