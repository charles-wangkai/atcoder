import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(N, queries));

    sc.close();
  }

  static String solve(int N, String[] queries) {
    List<String> result = new ArrayList<>();
    Map<Integer, Integer> playerToPenalty = new HashMap<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      int type = fields[0];
      int x = fields[1];

      if (type == 1) {
        playerToPenalty.put(x, playerToPenalty.getOrDefault(x, 0) + 1);
      } else if (type == 2) {
        playerToPenalty.put(x, playerToPenalty.getOrDefault(x, 0) + 2);
      } else {
        result.add((playerToPenalty.getOrDefault(x, 0) >= 2) ? "Yes" : "No");
      }
    }

    return String.join("\n", result);
  }
}