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

    System.out.println("%.9f".formatted(solve(A)));

    sc.close();
  }

  static double solve(int[] A) {
    return 1 / Arrays.stream(A).mapToDouble(Ai -> 1.0 / Ai).sum();
  }
}