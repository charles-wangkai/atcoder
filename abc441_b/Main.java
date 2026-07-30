import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    sc.nextInt();
    String S = sc.next();
    String T = sc.next();
    int Q = sc.nextInt();
    String[] w = new String[Q];
    for (int i = 0; i < w.length; ++i) {
      w[i] = sc.next();
    }

    System.out.println(solve(S, T, w));

    sc.close();
  }

  static String solve(String S, String T, String[] w) {
    Set<Character> sSet = S.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
    Set<Character> tSet = T.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

    return Arrays.stream(w)
        .map(
            wi -> {
              boolean isTakahashi = isMatched(wi, sSet);
              boolean isAoki = isMatched(wi, tSet);

              if (isTakahashi && !isAoki) {
                return "Takahashi";
              }
              if (!isTakahashi && isAoki) {
                return "Aoki";
              }

              return "Unknown";
            })
        .collect(Collectors.joining("\n"));
  }

  static boolean isMatched(String word, Set<Character> set) {
    return word.chars().allMatch(c -> set.contains((char) c));
  }
}