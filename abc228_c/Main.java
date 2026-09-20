import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[][] P = new int[N][3];
    for (int i = 0; i < P.length; ++i) {
      for (int j = 0; j < P[i].length; ++j) {
        P[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(P, K));

    sc.close();
  }

  static String solve(int[][] P, int K) {
    int[] scores = Arrays.stream(P).mapToInt(Pi -> Arrays.stream(Pi).sum()).toArray();

    int[] sortedScores =
        Arrays.stream(scores)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    return Arrays.stream(scores)
        .mapToObj(score -> (score + 300 >= sortedScores[K - 1]) ? "Yes" : "No")
        .collect(Collectors.joining("\n"));
  }
}