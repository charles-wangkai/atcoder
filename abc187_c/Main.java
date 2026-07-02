import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
    Set<String> positives = new HashSet<>();
    Set<String> negatives = new HashSet<>();
    for (String Si : S) {
      if (Si.startsWith("!")) {
        negatives.add(Si.substring(1));
      } else {
        positives.add(Si);
      }
    }

    return positives.stream().filter(negatives::contains).findAny().orElse("satisfiable");
  }
}