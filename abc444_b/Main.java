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
    return (int)
        IntStream.rangeClosed(1, N)
            .filter(x -> String.valueOf(x).chars().map(c -> c - '0').sum() == K)
            .count();
  }
}