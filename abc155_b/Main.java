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

    System.out.println(solve(A) ? "APPROVED" : "DENIED");

    sc.close();
  }

  static boolean solve(int[] A) {
    return Arrays.stream(A).allMatch(x -> x % 2 == 1 || x % 3 == 0 || x % 5 == 0);
  }
}