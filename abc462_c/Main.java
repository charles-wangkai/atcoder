import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] X = new int[N];
    int[] Y = new int[N];
    for (int i = 0; i < N; ++i) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }

    System.out.println(solve(X, Y));

    sc.close();
  }

  static int solve(int[] X, int[] Y) {
    int[] sortedIndices =
        IntStream.range(0, X.length)
            .boxed()
            .sorted(Comparator.comparing(i -> X[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    int result = 0;
    int min = Integer.MAX_VALUE;
    for (int index : sortedIndices) {
      if (Y[index] < min) {
        min = Y[index];
        ++result;
      }
    }

    return result;
  }
}