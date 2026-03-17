import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(H, A) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int H, int[] A) {
    return Arrays.stream(A).sum() >= H;
  }
}