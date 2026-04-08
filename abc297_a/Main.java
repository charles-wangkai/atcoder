import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int D = sc.nextInt();
    int[] T = new int[N];
    for (int i = 0; i < T.length; ++i) {
      T[i] = sc.nextInt();
    }

    System.out.println(solve(T, D));

    sc.close();
  }

  static int solve(int[] T, int D) {
    return IntStream.range(1, T.length)
        .filter(i -> T[i] - T[i - 1] <= D)
        .map(i -> T[i])
        .findFirst()
        .orElse(-1);
  }
}