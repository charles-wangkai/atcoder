import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    String T = sc.next();

    System.out.println(solve(S, T));

    sc.close();
  }

  static String solve(String S, String T) {
    List<Integer> decreaseIndices = new ArrayList<>();
    List<Integer> increaseIndices = new ArrayList<>();
    for (int i = 0; i < S.length(); ++i) {
      if (T.charAt(i) < S.charAt(i)) {
        decreaseIndices.add(i);
      } else if (T.charAt(i) > S.charAt(i)) {
        increaseIndices.add(i);
      }
    }

    List<String> X = new ArrayList<>();
    char[] letters = S.toCharArray();
    for (int decreaseIndex : decreaseIndices) {
      letters[decreaseIndex] = T.charAt(decreaseIndex);
      X.add(String.valueOf(letters));
    }
    for (int increaseIndex : increaseIndices.reversed()) {
      letters[increaseIndex] = T.charAt(increaseIndex);
      X.add(String.valueOf(letters));
    }

    return "%d\n%s".formatted(X.size(), String.join("\n", X));
  }
}