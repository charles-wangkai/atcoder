import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static long solve(int N) {
    return IntStream.range(1, N)
        .mapToLong(i -> (long) computePairNum(i) * computePairNum(N - i))
        .sum();
  }

  static int computePairNum(int product) {
    int result = 0;
    for (int i = 1; i * i <= product; ++i) {
      if (product % i == 0) {
        ++result;

        if (product / i != i) {
          ++result;
        }
      }
    }

    return result;
  }
}