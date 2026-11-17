import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int Q = sc.nextInt();
      int[] K = new int[Q];
      for (int i = 0; i < K.length; ++i) {
        K[i] = sc.nextInt();
      }

      System.out.println(solve(N, K));
    }
  }

  static String solve(int N, int[] K) {
    int[] cards = IntStream.rangeClosed(1, N).toArray();
    for (int Ki : K) {
      for (int i = 0; i < Ki; ++i) {
        cards[i] *= -1;
      }
      for (int i = 0, j = Ki - 1; i < j; ++i, --j) {
        int temp = cards[i];
        cards[i] = cards[j];
        cards[j] = temp;
      }
    }

    return Arrays.stream(cards).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}