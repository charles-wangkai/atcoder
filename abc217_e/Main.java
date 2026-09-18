import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
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
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Queue<Integer> queue = new ArrayDeque<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int x = fields[1];

        queue.offer(x);
      } else if (fields[0] == 2) {
        int element;
        if (!pq.isEmpty()) {
          element = pq.poll();
        } else {
          element = queue.poll();
        }

        result.add(element);
      } else {
        while (!queue.isEmpty()) {
          pq.offer(queue.poll());
        }
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}