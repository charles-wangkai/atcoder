import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
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
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < 100; ++i) {
      stack.push(0);
    }

    List<Integer> result = new ArrayList<>();
    for (String query : queries) {
      int[] fields = Arrays.stream(query.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        stack.push(fields[1]);
      } else {
        result.add(stack.pop());
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}