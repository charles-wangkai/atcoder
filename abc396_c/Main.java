import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }
    int[] W = new int[M];
    for (int i = 0; i < W.length; ++i) {
      W[i] = sc.nextInt();
    }

    System.out.println(solve(B, W));

    sc.close();
  }

  static long solve(int[] B, int[] W) {
    B =
        Arrays.stream(B)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
    long bRestSum = Arrays.stream(B).map(Bi -> Math.max(0, Bi)).asLongStream().sum();

    W =
        Arrays.stream(W)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    long result = bRestSum;
    long chosenSum = 0;
    for (int i = 0; i < Math.min(B.length, W.length); ++i) {
      bRestSum -= Math.max(0, B[i]);
      chosenSum += B[i] + W[i];

      result = Math.max(result, chosenSum + bRestSum);
    }

    return result;
  }
}