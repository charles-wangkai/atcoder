import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[][] GROUPS = {{1, 3, 5, 7, 8, 10, 12}, {4, 6, 9, 11}, {2}};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();
    int y = sc.nextInt();

    System.out.println(solve(x, y) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int x, int y) {
    return findGroup(x) == findGroup(y);
  }

  static int findGroup(int n) {
    return IntStream.range(0, GROUPS.length)
        .filter(i -> Arrays.stream(GROUPS[i]).anyMatch(x -> x == n))
        .findAny()
        .getAsInt();
  }
}