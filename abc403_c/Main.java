import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int Q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(N, M, queries));

    sc.close();
  }

  static String solve(int N, int M, String[] queries) {
    List<String> result = new ArrayList<>();
    Set<Grant> grants = new HashSet<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int X = fields[1];
        int Y = fields[2];

        grants.add(new Grant(X, Y));
      } else if (fields[0] == 2) {
        int X = fields[1];

        grants.add(new Grant(X, 0));
      } else {
        int X = fields[1];
        int Y = fields[2];

        result.add(
            (grants.contains(new Grant(X, 0)) || grants.contains(new Grant(X, Y))) ? "Yes" : "No");
      }
    }

    return String.join("\n", result);
  }
}

record Grant(int user, int page) {}
