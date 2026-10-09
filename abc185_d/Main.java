import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[M];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(N, A));

    sc.close();
  }

  static int solve(int N, int[] A) {
    Arrays.sort(A);

    int[] lengths =
        IntStream.rangeClosed(0, A.length)
            .map(i -> ((i == A.length) ? (N + 1) : A[i]) - ((i == 0) ? 0 : A[i - 1]) - 1)
            .filter(length -> length != 0)
            .sorted()
            .toArray();
    if (lengths.length == 0) {
      return 0;
    }

    return Arrays.stream(lengths).map(length -> Math.ceilDiv(length, lengths[0])).sum();
  }
}