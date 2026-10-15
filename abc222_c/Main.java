import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    char[][] A = new char[2 * N][M];
    for (int i = 0; i < A.length; ++i) {
      String line = sc.next();
      for (int j = 0; j < A[i].length; ++j) {
        A[i][j] = line.charAt(j);
      }
    }

    System.out.println(solve(A));

    sc.close();
  }

  static String solve(char[][] A) {
    int N = A.length / 2;
    int M = A[0].length;

    int[] winCounts = new int[2 * N];
    int[] sortedIndices = buildSortedIndices(winCounts);
    for (int j = 0; j < M; ++j) {
      for (int i = 0; i < N; ++i) {
        int winnerIndex = getWinnerIndex(A, j, sortedIndices[i * 2], sortedIndices[i * 2 + 1]);
        if (winnerIndex != -1) {
          ++winCounts[winnerIndex];
        }
      }

      sortedIndices = buildSortedIndices(winCounts);
    }

    return Arrays.stream(sortedIndices)
        .map(index -> index + 1)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int getWinnerIndex(char[][] A, int round, int player1, int player2) {
    char hand1 = A[player1][round];
    char hand2 = A[player2][round];

    if (hand1 == hand2) {
      return -1;
    }

    return isWin(hand1, hand2) ? player1 : player2;
  }

  static boolean isWin(char hand1, char hand2) {
    return (hand1 == 'G' && hand2 == 'C')
        || (hand1 == 'C' && hand2 == 'P')
        || (hand1 == 'P' && hand2 == 'G');
  }

  static int[] buildSortedIndices(int[] winCounts) {
    return IntStream.range(0, winCounts.length)
        .boxed()
        .sorted(
            Comparator.<Integer, Integer>comparing(i -> winCounts[i])
                .reversed()
                .thenComparing(i -> i))
        .mapToInt(Integer::intValue)
        .toArray();
  }
}