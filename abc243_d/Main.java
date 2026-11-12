import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    long X = sc.nextLong();
    String S = sc.next();

    System.out.println(solve(S, X));

    sc.close();
  }

  static long solve(String S, long X) {
    List<Character> moves = new ArrayList<>();
    for (char move : S.toCharArray()) {
      if (move == 'U' && !moves.isEmpty() && (moves.getLast() == 'L' || moves.getLast() == 'R')) {
        moves.removeLast();
      } else {
        moves.add(move);
      }
    }

    long result = X;
    for (char move : moves) {
      if (move == 'U') {
        result /= 2;
      } else if (move == 'L') {
        result *= 2;
      } else {
        result = result * 2 + 1;
      }
    }

    return result;
  }
}