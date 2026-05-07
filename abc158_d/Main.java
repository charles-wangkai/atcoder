import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    int Q = sc.nextInt();
    sc.nextLine();
    String[] queries = new String[Q];
    for (int i = 0; i < queries.length; ++i) {
      queries[i] = sc.nextLine();
    }

    System.out.println(solve(S, queries));

    sc.close();
  }

  static String solve(String S, String[] queries) {
    Deque<Character> deque = new ArrayDeque<>();
    for (char letter : S.toCharArray()) {
      deque.offer(letter);
    }

    boolean reversed = false;
    for (String query : queries) {
      String[] fields = query.split(" ");
      if (fields[0].equals("1")) {
        reversed ^= true;
      } else {
        char C = fields[2].charAt(0);

        if ((fields[1].equals("1") && !reversed) || (fields[1].equals("2") && reversed)) {
          deque.offerFirst(C);
        } else {
          deque.offerLast(C);
        }
      }
    }

    if (reversed) {
      deque = deque.reversed();
    }

    return deque.stream().map(String::valueOf).collect(Collectors.joining());
  }
}