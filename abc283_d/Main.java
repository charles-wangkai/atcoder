import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    Set<Character> inBox = new HashSet<>();
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : S.toCharArray()) {
      if (c == ')') {
        while (true) {
          char top = stack.pop();
          if (top == '(') {
            break;
          }

          inBox.remove(top);
        }
      } else {
        if (c != '(') {
          if (inBox.contains(c)) {
            return false;
          }

          inBox.add(c);
        }

        stack.push(c);
      }
    }

    return true;
  }
}