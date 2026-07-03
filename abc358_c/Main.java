import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String[] S) {
    int N = S.length;
    int M = S[0].length();

    return IntStream.range(0, 1 << N)
        .filter(
            mask -> {
              Set<Integer> seen = new HashSet<>();
              for (int i = 0; i < N; ++i) {
                if (((mask >> i) & 1) == 1) {
                  for (int j = 0; j < M; ++j) {
                    if (S[i].charAt(j) == 'o') {
                      seen.add(j);
                    }
                  }
                }
              }

              return seen.size() == M;
            })
        .map(Integer::bitCount)
        .min()
        .getAsInt();
  }
}