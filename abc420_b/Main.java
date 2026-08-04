import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S, M));

    sc.close();
  }

  static String solve(String[] S, int M) {
    int N = S.length;

    int[] scores = new int[N];
    for (int j = 0; j < M; ++j) {
      int j_ = j;
      int x = (int) IntStream.range(0, N).filter(i -> S[i].charAt(j_) == '0').count();
      int y = N - x;
      char target = (y == 0 || x < y) ? '0' : '1';
      for (int i = 0; i < N; ++i) {
        if (S[i].charAt(j) == target) {
          ++scores[i];
        }
      }
    }

    int maxScore = Arrays.stream(scores).max().getAsInt();

    return IntStream.range(0, scores.length)
        .filter(i -> scores[i] == maxScore)
        .map(i -> i + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}