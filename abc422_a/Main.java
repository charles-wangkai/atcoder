import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    int[] fields = Arrays.stream(S.split("-")).mapToInt(Integer::parseInt).toArray();
    int i = fields[0];
    int j = fields[1];
    if (j == 8) {
      ++i;
      j = 1;
    } else {
      ++j;
    }

    return "%d-%d".formatted(i, j);
  }
}