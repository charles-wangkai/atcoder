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

  static long solve(int[] A) {
    int[] diffs = IntStream.range(0, A.length - 1).map(i -> A[i + 1] - A[i]).toArray();

    long result = A.length;
    int count = 0;
    for (int i = 0; i <= diffs.length; ++i) {
      if (i != 0 && i != diffs.length && diffs[i] == diffs[i - 1]) {
        ++count;
      } else {
        result += count * (count + 1L) / 2;
        count = 1;
      }
    }

    return result;
  }
}