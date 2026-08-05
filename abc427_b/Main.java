import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    int[] A = new int[N + 1];
    A[0] = 1;
    for (int i = 1; i < A.length; ++i) {
      A[i] =
          IntStream.range(0, i)
              .map(j -> String.valueOf(A[j]).chars().map(c -> c - '0').sum())
              .sum();
    }

    return A[N];
  }
}