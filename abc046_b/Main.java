import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(N, K));

    sc.close();
  }

  static int solve(int N, int K) {
    return K * IntStream.range(0, N - 1).reduce(1, (acc, x) -> acc * (K - 1));
  }
}