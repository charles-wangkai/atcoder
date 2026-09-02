import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    List<Long> result = new ArrayList<>();
    Queue<Element> queue = new ArrayDeque<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        int c = fields[1];
        int x = fields[2];

        queue.offer(new Element(c, x));
      } else {
        int k = fields[1];

        long sum = 0;
        while (true) {
          Element head = queue.peek();

          if (head.count >= k) {
            sum += (long) k * head.value;
            head.count -= k;

            break;
          }

          sum += (long) head.count * head.value;
          queue.poll();
          k -= head.count;
        }

        result.add(sum);
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class Element {
  int count;
  int value;

  Element(int count, int value) {
    this.count = count;
    this.value = value;
  }
}
