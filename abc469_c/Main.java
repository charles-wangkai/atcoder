import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    int[] result = new int[S.length()];
    int index = -1;
    int hitRest = 0;
    for (int i = 0; i < result.length; ++i) {
      ++hitRest;

      while (index != S.length() - 1 && hitRest != 0) {
        ++index;
        --hitRest;
        if (S.charAt(index) == 'o') {
          ++hitRest;
        }
      }

      result[i] = index + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}