import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < P.length; ++i) {
      P[i] = sc.nextInt();
    }

    System.out.println(solve(P));

    sc.close();
  }

  static int solve(int[] P) {
    return (P.length == 1)
        ? 0
        : Math.max(0, IntStream.range(1, P.length).map(i -> P[i]).max().getAsInt() + 1 - P[0]);
  }
}