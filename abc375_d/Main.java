import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static long solve(String S) {
    int[] leftCounts = new int[26];

    int[] rightCounts = new int[26];
    for (char letter : S.toCharArray()) {
      ++rightCounts[letter - 'A'];
    }

    long result = 0;
    for (char letter : S.toCharArray()) {
      --rightCounts[letter - 'A'];

      result += IntStream.range(0, 26).mapToLong(i -> (long) leftCounts[i] * rightCounts[i]).sum();

      ++leftCounts[letter - 'A'];
    }

    return result;
  }
}