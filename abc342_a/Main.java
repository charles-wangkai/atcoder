import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    Map<Character, List<Integer>> letterToIndices = new HashMap<>();
    for (int i = 0; i < S.length(); ++i) {
      letterToIndices.putIfAbsent(S.charAt(i), new ArrayList<>());
      letterToIndices.get(S.charAt(i)).add(i);
    }

    return letterToIndices.values().stream()
            .filter(indices -> indices.size() == 1)
            .mapToInt(indices -> indices.get(0))
            .findAny()
            .getAsInt()
        + 1;
  }
}