import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] H = new int[N];
    for (int i = 0; i < H.length; ++i) {
      H[i] = sc.nextInt();
    }

    System.out.println(solve(H) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] H) {
    int[] dp = {H[0], H[0] - 1};
    for (int i = 1; i < H.length; ++i) {
      int i_ = i;
      int[] dp_ = dp;
      dp =
          IntStream.rangeClosed(0, 1)
              .map(d -> H[i_] - d)
              .filter(x -> Arrays.stream(dp_).anyMatch(p -> p <= x))
              .toArray();
      if (dp.length == 0) {
        return false;
      }
    }

    return true;
  }
}