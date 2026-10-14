import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  static final Set<Integer> ALLOWED =
      "atcoder".chars().map(c -> c - 'a' + 1).boxed().collect(Collectors.toSet());

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S, String T) {
    int[] sCounts = buildCounts(S);
    int[] tCounts = buildCounts(T);

    int sExtraCount = 0;
    int tExtraCount = 0;
    for (int i = 1; i < sCounts.length; ++i) {
      if (sCounts[i] != tCounts[i]) {
        if (!ALLOWED.contains(i)) {
          return false;
        }

        if (sCounts[i] > tCounts[i]) {
          sExtraCount += sCounts[i] - tCounts[i];
        } else {
          tExtraCount += tCounts[i] - sCounts[i];
        }
      }
    }

    return sCounts[0] >= tExtraCount && tCounts[0] >= sExtraCount;
  }

  static int[] buildCounts(String str) {
    int[] result = new int[27];
    for (char c : str.toCharArray()) {
      ++result[(c == '@') ? 0 : (c - 'a' + 1)];
    }

    return result;
  }
}