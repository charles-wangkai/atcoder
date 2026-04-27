import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }
    String[] T = new String[M];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.next();
    }

    System.out.println(solve(S, T));

    sc.close();
  }

  static String solve(String[] S, String[] T) {
    Set<String> tSet = Arrays.stream(T).collect(Collectors.toSet());

    return Arrays.stream(S)
        .map(Si -> tSet.contains(Si) ? "Yes" : "No")
        .collect(Collectors.joining("\n"));
  }
}