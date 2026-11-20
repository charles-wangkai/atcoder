import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String S = sc.next();

      System.out.println(solve(S));
    }
  }

  static int solve(String S) {
    Map<Character, Queue<Integer>> letterToIndices =
        Stream.of('A', 'B', 'C')
            .collect(Collectors.toMap(letter -> letter, letter -> new ArrayDeque<>()));
    for (int i = 0; i < S.length(); ++i) {
      letterToIndices.get(S.charAt(i)).offer(i);
    }

    int result = 0;
    while (true) {
      if (letterToIndices.get('A').isEmpty()) {
        break;
      }
      int aIndex = letterToIndices.get('A').poll();

      while (!letterToIndices.get('B').isEmpty() && letterToIndices.get('B').peek() < aIndex) {
        letterToIndices.get('B').poll();
      }
      if (letterToIndices.get('B').isEmpty()) {
        break;
      }
      int bIndex = letterToIndices.get('B').poll();

      while (!letterToIndices.get('C').isEmpty() && letterToIndices.get('C').peek() < bIndex) {
        letterToIndices.get('C').poll();
      }
      if (letterToIndices.get('C').isEmpty()) {
        break;
      }
      letterToIndices.get('C').poll();

      ++result;
    }

    return result;
  }
}