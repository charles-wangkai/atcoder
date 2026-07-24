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
    int[] divisorCounts = new int[N + 1];
    for (int i = 1; i < divisorCounts.length; ++i) {
      for (int j = i; j < divisorCounts.length; j += i) {
        ++divisorCounts[j];
      }
    }

    return IntStream.rangeClosed(1, N).mapToLong(i -> (long) i * divisorCounts[i]).sum();
  }
}