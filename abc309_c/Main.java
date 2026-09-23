import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] a = new int[N];
    int[] b = new int[N];
    for (int i = 0; i < N; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, K));

    sc.close();
  }

  static int solve(int[] a, int[] b, int K) {
    int[] candidates =
        IntStream.concat(IntStream.of(1), Arrays.stream(a).map(ai -> ai + 1)).sorted().toArray();

    int index = -1;
    int lower = 0;
    int upper = candidates.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(a, b, K, candidates[middle])) {
        index = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return candidates[index];
  }

  static boolean check(int[] a, int[] b, int K, int day) {
    return IntStream.range(0, a.length).filter(i -> a[i] >= day).map(i -> b[i]).asLongStream().sum()
        <= K;
  }
}