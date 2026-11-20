import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int T = sc.nextInt();
      for (int tc = 0; tc < T; ++tc) {
        int N = sc.nextInt();
        int[] S = new int[N];
        for (int i = 0; i < S.length; ++i) {
          S[i] = sc.nextInt();
        }

        System.out.println(solve(S));
      }
    }
  }

  static int solve(int[] S) {
    int[] values =
        IntStream.concat(
                IntStream.of(S[0]), IntStream.range(1, S.length - 1).map(i -> S[i]).sorted())
            .toArray();

    int result = 2;
    int index = 0;
    while (values[index] * 2 < S[S.length - 1]) {
      int nextIndex = index;
      while (nextIndex != values.length - 1 && values[nextIndex + 1] <= 2 * values[index]) {
        ++nextIndex;
      }
      if (nextIndex == index) {
        return -1;
      }

      ++result;
      index = nextIndex;
    }

    return result;
  }
}