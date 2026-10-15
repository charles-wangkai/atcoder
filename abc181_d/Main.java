import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    int[] counts = new int[10];
    for (char c : S.toCharArray()) {
      ++counts[c - '0'];
    }

    int digitNum = Math.min(3, S.length());

    return IntStream.range(pow10(digitNum - 1), pow10(digitNum))
        .filter(i -> i % 8 == 0)
        .anyMatch(i -> canCover(counts, i));
  }

  static int pow10(int exponent) {
    return IntStream.range(0, exponent).reduce(1, (acc, x) -> acc * 10);
  }

  static boolean canCover(int[] counts, int value) {
    int[] needed = new int[10];
    while (value != 0) {
      ++needed[value % 10];
      value /= 10;
    }

    return IntStream.range(0, 10).allMatch(i -> needed[i] <= counts[i]);
  }
}