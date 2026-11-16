import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int K = sc.nextInt();
      int[] A = new int[K];
      for (int i = 0; i < A.length; ++i) {
        A[i] = sc.nextInt();
      }

      System.out.println(solve(A));
    }
  }

  static int solve(int[] A) {
    return (Arrays.stream(A).max().getAsInt() == 9) ? Arrays.stream(A).min().getAsInt() : -1;
  }
}