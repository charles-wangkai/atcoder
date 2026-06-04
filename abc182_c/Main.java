import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(long N) {
    String s = String.valueOf(N);

    int[] counts = new int[3];
    for (char c : s.toCharArray()) {
      ++counts[(c - '0') % 3];
    }

    int sumRemainder = s.chars().map(c -> c - '0').sum() % 3;
    if (sumRemainder == 0) {
      return 0;
    }
    if (counts[0] == 0 && s.length() <= 2) {
      return -1;
    }

    return (counts[sumRemainder] == 0) ? 2 : 1;
  }
}