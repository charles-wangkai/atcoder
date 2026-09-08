import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    int[] T = new int[N];
    for (int i = 0; i < N; ++i) {
      S[i] = sc.next();
      T[i] = sc.nextInt();
    }

    System.out.println(solve(S, T));

    sc.close();
  }

  static int solve(String[] S, int[] T) {
    Map<String, Integer> strToFirstIndex = new HashMap<>();
    for (int i = 0; i < S.length; ++i) {
      strToFirstIndex.putIfAbsent(S[i], i);
    }

    return strToFirstIndex.values().stream()
            .max(
                Comparator.<Integer, Integer>comparing(index -> T[index])
                    .thenComparing(Comparator.reverseOrder()))
            .get()
        + 1;
  }
}