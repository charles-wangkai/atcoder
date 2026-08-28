import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] F = new int[N];
    int[] S = new int[N];
    for (int i = 0; i < N; ++i) {
      F[i] = sc.nextInt();
      S[i] = sc.nextInt();
    }

    System.out.println(solve(F, S));

    sc.close();
  }

  static int solve(int[] F, int[] S) {
    Map<Integer, List<Integer>> flavorToDelishList = new HashMap<>();
    for (int i = 0; i < F.length; ++i) {
      flavorToDelishList.putIfAbsent(F[i], new ArrayList<>());
      flavorToDelishList.get(F[i]).add(S[i]);
    }
    for (List<Integer> delishList : flavorToDelishList.values()) {
      Collections.sort(delishList, Comparator.reverseOrder());
    }

    return Math.max(
        (flavorToDelishList.size() >= 2)
            ? flavorToDelishList.values().stream()
                .mapToInt(delishList -> delishList.get(0))
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .mapToInt(Integer::intValue)
                .sum()
            : -1,
        flavorToDelishList.values().stream()
            .filter(delishList -> delishList.size() >= 2)
            .mapToInt(delishList -> delishList.get(0) + delishList.get(1) / 2)
            .max()
            .orElse(-1));
  }
}