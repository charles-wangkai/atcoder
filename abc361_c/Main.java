import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, K));

    sc.close();
  }

  static int solve(int[] A, int K) {
    Arrays.sort(A);

    return IntStream.rangeClosed(0, K).map(i -> A[i + (A.length - K) - 1] - A[i]).min().getAsInt();
  }
}