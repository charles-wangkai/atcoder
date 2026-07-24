import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S, A));

    sc.close();
  }

  static String solve(String[] S, int[] A) {
    int N = S.length;

    int[] scores =
        IntStream.range(0, S.length)
            .map(
                i ->
                    IntStream.range(0, S[i].length())
                            .filter(j -> S[i].charAt(j) == 'o')
                            .map(j -> A[j])
                            .sum()
                        + (i + 1))
            .toArray();

    return IntStream.range(0, N)
        .map(
            i -> {
              int diff =
                  IntStream.range(0, scores.length)
                          .filter(j -> j != i)
                          .map(j -> scores[j])
                          .max()
                          .getAsInt()
                      + 1
                      - scores[i];

              int[] problemScores =
                  IntStream.range(0, A.length)
                      .filter(j -> S[i].charAt(j) == 'x')
                      .map(j -> A[j])
                      .boxed()
                      .sorted(Comparator.reverseOrder())
                      .mapToInt(Integer::intValue)
                      .toArray();

              int result = 0;
              for (int problemScore : problemScores) {
                if (diff > 0) {
                  diff -= problemScore;
                  ++result;
                }
              }

              return result;
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}