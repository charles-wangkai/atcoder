import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
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
    int[] leftDistinctNums = new int[A.length];
    Set<Integer> leftSeen = new HashSet<>();
    for (int i = 0; i < leftDistinctNums.length; ++i) {
      leftSeen.add(A[i]);
      leftDistinctNums[i] = leftSeen.size();
    }

    int[] rightDistinctNums = new int[A.length];
    Set<Integer> rightSeen = new HashSet<>();
    for (int i = rightDistinctNums.length - 1; i >= 0; --i) {
      rightSeen.add(A[i]);
      rightDistinctNums[i] = rightSeen.size();
    }

    return IntStream.range(0, A.length - 1)
        .map(i -> leftDistinctNums[i] + rightDistinctNums[i + 1])
        .max()
        .getAsInt();
  }
}