import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int Q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(queries));

    sc.close();
  }

  static String solve(String[] queries) {
    List<Integer> result = new ArrayList<>();
    SortedMap<Integer, Integer> valueToCount = new TreeMap<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int x = fields[1];

        updateMap(valueToCount, x, 1);
      } else if (fields[0] == 2) {
        int x = fields[1];
        int c = fields[2];

        updateMap(valueToCount, x, -Math.min(c, valueToCount.getOrDefault(x, 0)));
      } else {
        result.add(valueToCount.lastKey() - valueToCount.firstKey());
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static void updateMap(SortedMap<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}