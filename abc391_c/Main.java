import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    String[] queries = new String[Q];
    sc.nextLine();
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(N, queries));

    sc.close();
  }

  static String solve(int N, String[] queries) {
    int[] pigeonToNest = IntStream.range(0, N).toArray();

    Map<Integer, Set<Integer>> nestToPigeons = new HashMap<>();
    for (int i = 0; i < N; ++i) {
      Set<Integer> pigeons = new HashSet<>();
      pigeons.add(i);

      nestToPigeons.put(i, pigeons);
    }

    List<Integer> result = new ArrayList<>();
    int multipleNestCount = 0;
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int P = fields[1];
        int H = fields[2];

        if (nestToPigeons.get(pigeonToNest[P - 1]).size() == 2) {
          --multipleNestCount;
        }
        nestToPigeons.get(pigeonToNest[P - 1]).remove(P - 1);

        pigeonToNest[P - 1] = H - 1;

        nestToPigeons.get(H - 1).add(P - 1);
        if (nestToPigeons.get(H - 1).size() == 2) {
          ++multipleNestCount;
        }
      } else {
        result.add(multipleNestCount);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}