import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : S.toCharArray()) {
      if (c == '(' || c == '[' || c == '<') {
        stack.push(c);
      } else if (!stack.isEmpty()
          && ((stack.peek() == '(' && c == ')')
              || (stack.peek() == '[' && c == ']')
              || (stack.peek() == '<' && c == '>'))) {
        stack.pop();
      } else {
        return false;
      }
    }

    return stack.isEmpty();
  }
}