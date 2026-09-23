import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] COLUMNS = {3, 2, 4, 1, 3, 5, 0, 2, 4, 6};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String S) {
    if (S.charAt(0) == '1') {
      return false;
    }

    boolean[] standings = new boolean[7];
    for (int i = 0; i < S.length(); ++i) {
      if (S.charAt(i) == '1') {
        standings[COLUMNS[i]] = true;
      }
    }

    for (int i = 0; i < standings.length; ++i) {
      for (int j = i + 1; j < standings.length; ++j) {
        if (standings[i]
            && standings[j]
            && IntStream.range(i + 1, j).anyMatch(k -> !standings[k])) {
          return true;
        }
      }
    }

    return false;
  }
}