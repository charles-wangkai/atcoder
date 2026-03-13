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
    int[] B = new int[N];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int[] A, int[] B) {
    return IntStream.range(0, A.length).map(i -> A[i] * B[i]).sum() == 0;
  }
}