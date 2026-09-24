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

    System.out.println(solve(A));

    sc.close();
  }

  static long solve(int[] A) {
    Arrays.sort(A);

    long result = Arrays.stream(A).asLongStream().sum() * (A.length - 1);
    int beginIndex = A.length;
    for (int i = 0; i < A.length; ++i) {
      while (beginIndex != 0 && A[beginIndex - 1] + A[i] >= 100_000_000) {
        --beginIndex;
      }

      result -= (A.length - Math.max(beginIndex, i + 1)) * 100_000_000L;
    }

    return result;
  }
}