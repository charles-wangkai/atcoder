import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int Q = sc.nextInt();
    int[] a = new int[Q];
    int[] b = new int[Q];
    int[] c = new int[Q];
    int[] d = new int[Q];
    for (int i = 0; i < Q; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    System.out.println(solve(N, M, a, b, c, d));

    sc.close();
  }

  static int solve(int N, int M, int[] a, int[] b, int[] c, int[] d) {
    int[] sequence = new int[N];
    sequence[0] = 1;

    return search(N, M, a, b, c, d, sequence, 1);
  }

  static int search(int N, int M, int[] a, int[] b, int[] c, int[] d, int[] sequence, int index) {
    if (index == sequence.length) {
      return IntStream.range(0, a.length)
          .filter(i -> sequence[b[i] - 1] - sequence[a[i] - 1] == c[i])
          .map(i -> d[i])
          .sum();
    }

    int result = Integer.MIN_VALUE;
    for (int value = sequence[index - 1]; value <= M; ++value) {
      sequence[index] = value;
      result = Math.max(result, search(N, M, a, b, c, d, sequence, index + 1));
    }

    return result;
  }
}