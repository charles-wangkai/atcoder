import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] a = new int[M];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(N, a));

    sc.close();
  }

  static String solve(int N, int[] a) {
    boolean[] marks = new boolean[N];
    for (int ai : a) {
      marks[ai - 1] = true;
    }

    int[] result = IntStream.rangeClosed(1, N).toArray();
    int beginIndex = 0;
    while (beginIndex != result.length) {
      int endIndex = beginIndex;
      while (marks[endIndex]) {
        ++endIndex;
      }

      for (int i = beginIndex, j = endIndex; i < j; ++i, --j) {
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
      }

      beginIndex = endIndex + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}