import static java.util.Map.entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final char[] HANDS = {'r', 's', 'p'};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int K = sc.nextInt();
    int R = sc.nextInt();
    int S = sc.nextInt();
    int P = sc.nextInt();
    String T = sc.next();

    System.out.println(solve(T, K, R, S, P));

    sc.close();
  }

  static int solve(String T, int K, int R, int S, int P) {
    Map<Character, Integer> handToPoint =
        Map.ofEntries(entry('r', R), entry('s', S), entry('p', P));

    @SuppressWarnings("unchecked")
    List<Character>[] handLists = new List[K];
    for (int i = 0; i < handLists.length; ++i) {
      handLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < T.length(); ++i) {
      handLists[i % K].add(T.charAt(i));
    }

    return Arrays.stream(handLists).mapToInt(handList -> computeScore(handToPoint, handList)).sum();
  }

  static int computeScore(Map<Character, Integer> handToPoint, List<Character> handList) {
    Map<Character, Integer> dp = Map.of((char) 0, 0);
    for (char hand : handList) {
      Map<Character, Integer> nextDp = new HashMap<>();
      for (char prev : dp.keySet()) {
        for (char h : HANDS) {
          if (h != prev) {
            nextDp.put(
                h,
                Math.max(
                    nextDp.getOrDefault(h, 0),
                    dp.get(prev) + (isWin(h, hand) ? handToPoint.get(h) : 0)));
          }
        }
      }

      dp = nextDp;
    }

    return dp.values().stream().mapToInt(Integer::intValue).max().getAsInt();
  }

  static boolean isWin(char hand1, char hand2) {
    return (hand1 == 'r' && hand2 == 's')
        || (hand1 == 's' && hand2 == 'p')
        || (hand1 == 'p' && hand2 == 'r');
  }
}