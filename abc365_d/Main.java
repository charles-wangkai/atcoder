import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final char[] MOVES = {'R', 'P', 'S'};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    Map<Character, Integer> dp = Map.of((char) 0, 0);
    for (char m : S.toCharArray()) {
      Map<Character, Integer> nextDp = new HashMap<>();

      for (char lastMove : dp.keySet()) {
        for (char move : MOVES) {
          if (!isWin(m, move) && move != lastMove) {
            nextDp.put(
                move,
                Math.max(
                    nextDp.getOrDefault(move, 0), dp.get(lastMove) + (isWin(move, m) ? 1 : 0)));
          }
        }
      }

      dp = nextDp;
    }

    return dp.values().stream().mapToInt(Integer::intValue).max().getAsInt();
  }

  static boolean isWin(char move1, char move2) {
    return (move1 == 'R' && move2 == 'S')
        || (move1 == 'S' && move2 == 'P')
        || (move1 == 'P' && move2 == 'R');
  }
}