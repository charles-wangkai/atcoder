import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int Q = sc.nextInt();
      sc.nextLine();
      String[] queries = new String[Q];
      for (int i = 0; i < queries.length; ++i) {
        queries[i] = sc.nextLine();
      }

      System.out.println(solve(queries));
    }
  }

  static String solve(String[] queries) {
    Deque<Element> stack = new ArrayDeque<>();
    stack.push(new Element(0, 0));

    boolean[] goods = new boolean[queries.length];
    for (int i = 0; i < goods.length; ++i) {
      String[] fields = queries[i].split(" ");
      if (fields[0].equals("1")) {
        char c = fields[1].charAt(0);

        int depth = stack.peek().depth() + ((c == '(') ? 1 : -1);
        int minDepth = Math.min(stack.peek().minDepth(), depth);
        stack.push(new Element(depth, minDepth));
      } else {
        stack.pop();
      }

      goods[i] = stack.peek().depth() == 0 && stack.peek().minDepth() == 0;
    }

    return IntStream.range(0, goods.length)
        .mapToObj(i -> goods[i] ? "Yes" : "No")
        .collect(Collectors.joining("\n"));
  }
}

record Element(int depth, int minDepth) {}
