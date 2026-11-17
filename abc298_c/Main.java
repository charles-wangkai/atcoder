import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int Q = sc.nextInt();
      sc.nextLine();
      String[] queries = new String[Q];
      for (int i = 0; i < queries.length; ++i) {
        queries[i] = sc.nextLine();
      }

      System.out.println(solve(N, queries));
    }
  }

  static String solve(int N, String[] queries) {
    List<String> result = new ArrayList<>();
    Map<Integer, SortedMap<Integer, Integer>> boxToCardCountMap = new HashMap<>();
    Map<Integer, SortedSet<Integer>> cardToBoxes = new HashMap<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int card = fields[1];
        int box = fields[2];

        boxToCardCountMap.putIfAbsent(box, new TreeMap<>());
        boxToCardCountMap.get(box).put(card, boxToCardCountMap.get(box).getOrDefault(card, 0) + 1);

        cardToBoxes.putIfAbsent(card, new TreeSet<>());
        cardToBoxes.get(card).add(box);
      } else if (fields[0] == 2) {
        int box = fields[1];

        List<Integer> cards = new ArrayList<>();
        for (int card : boxToCardCountMap.get(box).keySet()) {
          for (int i = 0; i < boxToCardCountMap.get(box).get(card); ++i) {
            cards.add(card);
          }
        }

        result.add(cards.stream().map(String::valueOf).collect(Collectors.joining(" ")));
      } else {
        int card = fields[1];

        result.add(
            cardToBoxes.get(card).stream().map(String::valueOf).collect(Collectors.joining(" ")));
      }
    }

    return String.join("\n", result);
  }
}