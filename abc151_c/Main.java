import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] p = new int[M];
    String[] S = new String[M];
    for (int i = 0; i < M; ++i) {
      p[i] = sc.nextInt();
      S[i] = sc.next();
    }

    System.out.println(solve(N, p, S));

    sc.close();
  }

  static String solve(int N, int[] p, String[] S) {
    Set<Integer> correctProblems = new HashSet<>();
    Map<Integer, Integer> problemToWrongCount = new HashMap<>();
    int penaltyNum = 0;
    for (int i = 0; i < p.length; ++i) {
      if (S[i].equals("WA")) {
        problemToWrongCount.put(p[i], problemToWrongCount.getOrDefault(p[i], 0) + 1);
      } else if (!correctProblems.contains(p[i])) {
        correctProblems.add(p[i]);
        penaltyNum += problemToWrongCount.getOrDefault(p[i], 0);
      }
    }

    return "%d %d".formatted(correctProblems.size(), penaltyNum);
  }
}