import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[4 * N - 1];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[] A) {
    int N = (A.length + 1) / 4;

    return (int)
        (IntStream.rangeClosed(1, N).asLongStream().sum() * 4
            - Arrays.stream(A).asLongStream().sum());
  }
}