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
    int K = sc.nextInt();

    System.out.println(solve(A, K));

    sc.close();
  }

  static int solve(int[] A, int K) {
    return (int) Arrays.stream(A).filter(Ai -> Ai >= K).count();
  }
}