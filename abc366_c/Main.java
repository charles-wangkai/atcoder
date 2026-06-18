import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
    Map<Integer, Integer> ballToCount = new HashMap<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int x = fields[1];

        updateMap(ballToCount, x, 1);
      } else if (fields[0] == 2) {
        int x = fields[1];

        updateMap(ballToCount, x, -1);
      } else {
        result.add(ballToCount.size());
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }

  static void updateMap(Map<Integer, Integer> ballToCount, int ball, int delta) {
    ballToCount.put(ball, ballToCount.getOrDefault(ball, 0) + delta);
    ballToCount.remove(ball, 0);
  }
}