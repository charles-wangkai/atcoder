import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    List<Integer> squares = buildSquares(N);

    Map<Integer, Integer> squareSumToCount = new HashMap<>();
    for (int i = 0; i < squares.size(); ++i) {
      for (int j = i + 1; j < squares.size(); ++j) {
        int squareSum = squares.get(i) + squares.get(j);
        if (squareSum > N) {
          break;
        }

        squareSumToCount.put(squareSum, squareSumToCount.getOrDefault(squareSum, 0) + 1);
      }
    }

    int[] goods =
        squareSumToCount.keySet().stream()
            .filter(squareSum -> squareSumToCount.get(squareSum) == 1)
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();

    return "%d\n%s"
        .formatted(
            goods.length,
            Arrays.stream(goods).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  static List<Integer> buildSquares(int N) {
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i * i <= N; ++i) {
      result.add(i * i);
    }

    return result;
  }
}