import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] A) {
    return IntStream.range(1, A.length).allMatch(i -> (long) A[i] * A[0] == (long) A[i - 1] * A[1]);
  }
}