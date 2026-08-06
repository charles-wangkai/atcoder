import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int T = sc.nextInt();
    int[] A = new int[T];
    int[] B = new int[T];
    for (int i = 0; i < T; ++i) {
      A[i] = sc.nextInt();
      B[i] = sc.nextInt();
    }

    System.out.println(solve(N, A, B));

    sc.close();
  }

  static String solve(int N, int[] A, int[] B) {
    long[] scores = new long[N];

    Map<Long, Integer> scoreToCount = new HashMap<>();
    scoreToCount.put(0L, N);

    int[] result = new int[A.length];
    for (int i = 0; i < result.length; ++i) {
      updateMap(scoreToCount, scores[A[i] - 1], -1);
      scores[A[i] - 1] += B[i];
      updateMap(scoreToCount, scores[A[i] - 1], 1);

      result[i] = scoreToCount.size();
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }

  static void updateMap(Map<Long, Integer> scoreToCount, long score, int delta) {
    scoreToCount.put(score, scoreToCount.getOrDefault(score, 0) + delta);
    scoreToCount.remove(score, 0);
  }
}