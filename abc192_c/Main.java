import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();

    System.out.println(solve(N, K));

    sc.close();
  }

  static int solve(int N, int K) {
    for (int i = 0; i < K; ++i) {
      N = g1(N) - g2(N);
    }

    return N;
  }

  static int g1(int x) {
    return Integer.parseInt(
        String.valueOf(x)
            .chars()
            .map(c -> c - '0')
            .boxed()
            .sorted(Comparator.reverseOrder())
            .map(String::valueOf)
            .collect(Collectors.joining()));
  }

  static int g2(int x) {
    return Integer.parseInt(
        String.valueOf(x)
            .chars()
            .map(c -> c - '0')
            .sorted()
            .mapToObj(String::valueOf)
            .collect(Collectors.joining()));
  }
}