import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int X = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, K, X));

    sc.close();
  }

  static long solve(int[] A, int K, int X) {
    long couponNum = Arrays.stream(A).map(Ai -> Ai / X).asLongStream().sum();

    return (K <= couponNum)
        ? (Arrays.stream(A).asLongStream().sum() - (long) K * X)
        : Arrays.stream(A)
            .map(Ai -> Ai % X)
            .sorted()
            .limit(Math.max(0, A.length - (K - couponNum)))
            .asLongStream()
            .sum();
  }
}