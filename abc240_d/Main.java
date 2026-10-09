import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(int[] a) {
    Deque<Element> stack = new ArrayDeque<>();
    int ballNum = 0;

    int[] result = new int[a.length];
    for (int i = 0; i < result.length; ++i) {
      if (!stack.isEmpty() && stack.peek().value == a[i]) {
        ++stack.peek().count;
      } else {
        stack.push(new Element(a[i], 1));
      }
      ++ballNum;

      if (stack.peek().count == stack.peek().value) {
        ballNum -= stack.pop().count;
      }

      result[i] = ballNum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}

class Element {
  int value;
  int count;

  Element(int value, int count) {
    this.value = value;
    this.count = count;
  }
}
