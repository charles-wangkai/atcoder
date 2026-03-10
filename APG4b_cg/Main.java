import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] A = new int[5];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A) ? "YES" : "NO");

    sc.close();
  }

  static boolean solve(int[] A) {
    return IntStream.range(0, A.length - 1).anyMatch(i -> A[i] == A[i + 1]);
  }
}