import java.util.Scanner;
import java.util.stream.IntStream;

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

  static int solve(String[] S) {
    return IntStream.rangeClosed('0', '9')
        .map(target -> computeTime(S, (char) target))
        .min()
        .getAsInt();
  }

  static int computeTime(String[] S, char target) {
    int[] counts = new int[10];
    for (String Si : S) {
      ++counts[Si.indexOf(target)];
    }

    return IntStream.range(0, counts.length)
        .filter(i -> counts[i] != 0)
        .map(i -> i + (counts[i] - 1) * 10)
        .max()
        .getAsInt();
  }
}