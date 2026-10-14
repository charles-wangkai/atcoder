import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    int[] p = new int[A];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }
    int[] q = new int[B];
    for (int i = 0; i < q.length; ++i) {
      q[i] = sc.nextInt();
    }
    int[] r = new int[C];
    for (int i = 0; i < r.length; ++i) {
      r[i] = sc.nextInt();
    }

    System.out.println(solve(X, Y, p, q, r));

    sc.close();
  }

  static long solve(int X, int Y, int[] p, int[] q, int[] r) {
    int[] colored =
        IntStream.concat(
                Arrays.stream(p)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .limit(X),
                Arrays.stream(q)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .limit(Y))
            .sorted()
            .toArray();

    Arrays.sort(r);

    long result = Arrays.stream(colored).asLongStream().sum();

    int coloredIndex = 0;
    int rIndex = r.length - 1;
    while (coloredIndex != colored.length && rIndex != -1 && r[rIndex] > colored[coloredIndex]) {
      result += r[rIndex] - colored[coloredIndex];

      ++coloredIndex;
      --rIndex;
    }

    return result;
  }
}