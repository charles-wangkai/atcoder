import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] L = new int[N];
    for (int i = 0; i < L.length; ++i) {
      L[i] = sc.nextInt();
    }

    System.out.println(solve(L, M));

    sc.close();
  }

  static long solve(int[] L, int M) {
    long result = -1;
    long lower = Arrays.stream(L).max().getAsInt();
    long upper = Arrays.stream(L).asLongStream().sum() + (L.length - 1);
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      if (check(L, M, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int[] L, int M, long width) {
    int lineCount = 0;
    long rest = 0;
    for (int l : L) {
      if (l > rest) {
        ++lineCount;
        rest = width;
      }

      rest -= l + 1;
    }

    return lineCount <= M;
  }
}