import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
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
    List<Long> result = new ArrayList<>();
    PriorityQueue<Long> pq = new PriorityQueue<>();
    long delta = 0;
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      int type = fields[0];
      if (type == 1) {
        int x = fields[1];

        pq.offer(x - delta);
      } else if (type == 2) {
        int x = fields[1];

        delta += x;
      } else {
        result.add(pq.poll() + delta);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}