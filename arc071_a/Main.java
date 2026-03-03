import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String[] S = new String[n];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String[] S) {
    int[] counts = new int[26];
    Arrays.fill(counts, Integer.MAX_VALUE);

    for (String Si : S) {
      int[] c = new int[26];
      for (char ch : Si.toCharArray()) {
        ++c[ch - 'a'];
      }

      for (int i = 0; i < counts.length; ++i) {
        counts[i] = Math.min(counts[i], c[i]);
      }
    }

    return IntStream.range(0, counts.length)
        .mapToObj(i -> String.valueOf((char) ('a' + i)).repeat(counts[i]))
        .collect(Collectors.joining());
  }
}