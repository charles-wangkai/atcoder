import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String[] S) {
    int N = S.length;

    int M = Arrays.stream(S).mapToInt(String::length).max().getAsInt();

    char[][] converted = new char[M][N];
    for (int r = 0; r < converted.length; ++r) {
      Arrays.fill(converted[r], ' ');
    }

    for (int i = 0; i < S.length; ++i) {
      for (int j = 0; j < S[i].length(); ++j) {
        converted[j][N - 1 - i] = S[i].charAt(j);
      }
    }

    return Arrays.stream(converted)
        .map(line -> String.valueOf(line).stripTrailing().replace(' ', '*'))
        .collect(Collectors.joining("\n"));
  }
}