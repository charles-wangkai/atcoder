import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }
    int[] B = new int[M];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int[] A, int[] B) {
    Arrays.sort(A);
    Arrays.sort(B);

    int[] candidates =
        IntStream.concat(Arrays.stream(A), Arrays.stream(B).map(Bi -> Bi + 1))
            .distinct()
            .sorted()
            .toArray();

    int aIndex = -1;
    int bIndex = 0;
    for (int i = 0; ; ++i) {
      while (aIndex != A.length - 1 && A[aIndex + 1] <= candidates[i]) {
        ++aIndex;
      }
      while (bIndex != B.length && B[bIndex] < candidates[i]) {
        ++bIndex;
      }

      if (aIndex + 1 >= B.length - bIndex) {
        return candidates[i];
      }
    }
  }
}