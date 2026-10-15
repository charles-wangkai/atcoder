import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    char[][] S = new char[N][N];
    for (int r = 0; r < N; ++r) {
      String line = sc.next();
      for (int c = 0; c < N; ++c) {
        S[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(S, M));

    sc.close();
  }

  static int solve(char[][] S, int M) {
    int N = S.length;

    Set<String> patterns = new HashSet<>();
    for (int r = 0; r + M <= N; ++r) {
      for (int c = 0; c + M <= N; ++c) {
        int r_ = r;
        int c_ = c;
        patterns.add(
            IntStream.range(0, M)
                .mapToObj(
                    dr ->
                        IntStream.range(0, M)
                            .mapToObj(dc -> S[r_ + dr][c_ + dc])
                            .map(String::valueOf)
                            .collect(Collectors.joining()))
                .collect(Collectors.joining()));
      }
    }

    return patterns.size();
  }
}