import java.util.Arrays;
import java.util.Scanner;

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

  static long solve(int[] A, int K) {
    return (K + 1L) * K / 2
        - Arrays.stream(A).filter(Ai -> Ai <= K).distinct().asLongStream().sum();
  }
}