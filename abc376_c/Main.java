import java.util.Arrays;
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
    int[] B = new int[N - 1];
    for (int i = 0; i < B.length; ++i) {
      B[i] = sc.nextInt();
    }

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int[] A, int[] B) {
    Arrays.sort(A);
    Arrays.sort(B);

    int aIndex = A.length - 1;
    int bIndex = B.length - 1;
    while (bIndex != -1 && A[aIndex] <= B[bIndex]) {
      --aIndex;
      --bIndex;
    }

    return IntStream.range(0, aIndex).allMatch(i -> A[i] <= B[i]) ? A[aIndex] : -1;
  }
}