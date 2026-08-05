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

    System.out.println(solve(A));

    sc.close();
  }

  static int solve(int[] A) {
    int result = 0;
    for (int i = 0; i < A.length; ++i) {
      for (int j = i; j < A.length; ++j) {
        int sum = IntStream.rangeClosed(i, j).map(k -> A[k]).sum();
        if (IntStream.rangeClosed(i, j).allMatch(k -> sum % A[k] != 0)) {
          ++result;
        }
      }
    }

    return result;
  }
}