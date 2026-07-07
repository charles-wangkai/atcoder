import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long T = sc.nextLong();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, T));

    sc.close();
  }

  static String solve(int[] A, long T) {
    T %= Arrays.stream(A).asLongStream().sum();

    for (int i = 0; ; ++i) {
      if (A[i] > T) {
        return "%d %d".formatted(i + 1, T);
      }

      T -= A[i];
    }
  }
}