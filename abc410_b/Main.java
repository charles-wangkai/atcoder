import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();
    int[] X = new int[Q];
    for (int i = 0; i < X.length; ++i) {
      X[i] = sc.nextInt();
    }

    System.out.println(solve(N, X));

    sc.close();
  }

  static String solve(int N, int[] X) {
    int[] result = new int[X.length];
    int[] counts = new int[N];
    for (int i = 0; i < result.length; ++i) {
      int index;
      if (X[i] == 0) {
        int minCount = Arrays.stream(counts).min().getAsInt();
        index =
            IntStream.range(0, counts.length).filter(j -> counts[j] == minCount).min().getAsInt();
      } else {
        index = X[i] - 1;
      }

      result[i] = index + 1;
      ++counts[index];
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}