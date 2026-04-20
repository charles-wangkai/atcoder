import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int[] A = new int[N - 1];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, X));

    sc.close();
  }

  static int solve(int[] A, int X) {
    return IntStream.rangeClosed(0, 100).filter(i -> check(A, X, i)).findFirst().orElse(-1);
  }

  static boolean check(int[] A, int X, int score) {
    return IntStream.concat(Arrays.stream(A), IntStream.of(score))
            .sorted()
            .skip(1)
            .limit(A.length - 1)
            .sum()
        >= X;
  }
}