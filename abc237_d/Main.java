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
    int N = S.length();

    int[] result = new int[N + 1];
    int leftIndex = 0;
    int rightIndex = result.length - 1;
    for (int i = 0; i < S.length(); ++i) {
      if (S.charAt(i) == 'L') {
        result[rightIndex] = i;
        --rightIndex;
      } else {
        result[leftIndex] = i;
        ++leftIndex;
      }
    }
    result[leftIndex] = N;

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}