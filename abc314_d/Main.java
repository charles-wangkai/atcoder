import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();
    int Q = sc.nextInt();
    int[] t = new int[Q];
    int[] x = new int[Q];
    char[] c = new char[Q];
    for (int i = 0; i < Q; ++i) {
      t[i] = sc.nextInt();
      x[i] = sc.nextInt();
      c[i] = sc.next().charAt(0);
    }

    System.out.println(solve(S, t, x, c));

    sc.close();
  }

  static String solve(String S, int[] t, int[] x, char[] c) {
    OptionalInt caseLastIndex =
        IntStream.range(0, t.length).filter(i -> t[i] == 2 || t[i] == 3).max();

    char[] result = S.toCharArray();
    for (int i = 0; i < t.length; ++i) {
      if (t[i] == 1) {
        result[x[i] - 1] = c[i];
      } else if (i == caseLastIndex.getAsInt()) {
        for (int j = 0; j < result.length; ++j) {
          result[j] =
              (t[i] == 2) ? Character.toLowerCase(result[j]) : Character.toUpperCase(result[j]);
        }
      }
    }

    return String.valueOf(result);
  }
}