import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int Q = sc.nextInt();
      sc.nextLine();
      String[] events = new String[Q];
      for (int i = 0; i < events.length; ++i) {
        events[i] = sc.nextLine();
      }

      System.out.println(solve(N, events));
    }
  }

  static String solve(int N, String[] events) {
    List<Integer> result = new ArrayList<>();
    int next = 1;
    SortedSet<Integer> called = new TreeSet<>();
    for (String event : events) {
      int[] fields = Arrays.stream(event.split(" ")).mapToInt(Integer::parseInt).toArray();
      if (fields[0] == 1) {
        called.add(next);
        ++next;
      } else if (fields[0] == 2) {
        int x = fields[1];

        called.remove(x);
      } else {
        result.add(called.first());
      }
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}