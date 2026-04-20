import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] A = new int[4];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[] A) {
    Arrays.sort(A);

    if (A[0] == A[1] && A[2] == A[3]) {
      return 2;
    }

    return (Arrays.stream(A).distinct().count() == A.length) ? 0 : 1;
  }
}