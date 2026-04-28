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

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[] A) {
    int result = 0;
    while (Arrays.stream(A).filter(Ai -> Ai > 0).count() >= 2) {
      Arrays.sort(A);

      --A[A.length - 2];
      --A[A.length - 1];

      ++result;
    }

    return result;
  }
}