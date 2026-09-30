import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

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
    List<Integer> result = new ArrayList<>();
    Set<String> seen = new HashSet<>();
    for (int i = 0; i < S.length; ++i) {
      if (!seen.contains(S[i])) {
        seen.add(S[i]);
        result.add(i + 1);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}