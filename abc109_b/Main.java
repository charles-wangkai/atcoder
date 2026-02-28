import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] W = new String[N];
    for (int i = 0; i < W.length; ++i) {
      W[i] = sc.next();
    }

    System.out.println(solve(W) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String[] W) {
    return Arrays.stream(W).distinct().count() == W.length
        && IntStream.range(0, W.length - 1)
            .allMatch(i -> W[i].charAt(W[i].length() - 1) == W[i + 1].charAt(0));
  }
}