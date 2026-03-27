import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    long X = sc.nextLong();

    System.out.println(solve(A, X));

    sc.close();
  }

  static long solve(int[] A, long X) {
    long sum = Arrays.stream(A).asLongStream().sum();

    long result = X / sum * A.length;
    long rest = (X + 1) - X / sum * sum;
    for (int i = 0; ; ++i) {
      ++result;
      rest -= A[i];
      if (rest <= 0) {
        return result;
      }
    }
  }
}