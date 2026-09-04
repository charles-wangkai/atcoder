import java.util.Arrays;
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
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    int[] result = new int[queries.length];
    for (int i = 0; i < result.length; ++i) {
      int[] fields = Arrays.stream(queries[i].split(" ")).mapToInt(Integer::parseInt).toArray();
      int type = fields[0];
      int h = fields[1];

      if (type == 1) {
        pq.offer(h);
      } else {
        while (!pq.isEmpty() && pq.peek() <= h) {
          pq.poll();
        }
      }

      result[i] = pq.size();
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}