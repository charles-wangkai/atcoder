import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, M));

    sc.close();
  }

  static int solve(int[] A, int M) {
    Arrays.sort(A);

    int result = 0;
    int endIndex = 0;
    for (int beginIndex = 0; beginIndex < A.length; ++beginIndex) {
      while (endIndex != A.length - 1 && A[endIndex + 1] - A[beginIndex] < M) {
        ++endIndex;
      }

      result = Math.max(result, endIndex - beginIndex + 1);
    }

    return result;
  }
}