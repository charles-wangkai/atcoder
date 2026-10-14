import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int W = sc.nextInt();
    char[][] S = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        S[r][c] = line.charAt(c);
      }
    }
    char[][] T = new char[H][W];
    for (int r = 0; r < H; ++r) {
      String line = sc.next();
      for (int c = 0; c < W; ++c) {
        T[r][c] = line.charAt(c);
      }
    }

    System.out.println(solve(S, T) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(char[][] S, char[][] T) {
    return buildSortedColumns(S).equals(buildSortedColumns(T));
  }

  static List<String> buildSortedColumns(char[][] pattern) {
    int H = pattern.length;
    int W = pattern[0].length;

    return IntStream.range(0, W)
        .mapToObj(
            c ->
                IntStream.range(0, H)
                    .mapToObj(r -> pattern[r][c])
                    .map(String::valueOf)
                    .collect(Collectors.joining()))
        .sorted()
        .toList();
  }
}