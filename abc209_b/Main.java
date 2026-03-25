import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int X = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, X) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] A, int X) {
    return IntStream.range(0, A.length).map(i -> A[i] - i % 2).sum() <= X;
  }
}