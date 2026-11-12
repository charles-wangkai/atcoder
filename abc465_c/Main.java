import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    Deque<Integer> deque = new ArrayDeque<>();
    boolean reversed = false;
    for (int i = 0; i < S.length(); ++i) {
      if (reversed) {
        deque.offerFirst(i + 1);
      } else {
        deque.offerLast(i + 1);
      }

      if (S.charAt(i) == 'o') {
        reversed ^= true;
      }
    }

    return (reversed ? deque.reversed() : deque)
        .stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}