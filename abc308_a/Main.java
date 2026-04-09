import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] S = new int[8];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.nextInt();
    }

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] S) {
    return IntStream.range(0, S.length - 1).allMatch(i -> S[i] <= S[i + 1])
        && S[0] >= 100
        && S[S.length - 1] <= 675
        && Arrays.stream(S).allMatch(Si -> Si % 25 == 0);
  }
}