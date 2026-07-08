import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[][] a = new int[N][];
    for (int i = 0; i < a.length; ++i) {
      int L = sc.nextInt();
      a[i] = new int[L];
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[][] a) {
    Arrays.sort(a, Main::compare);

    return (int)
        IntStream.range(0, a.length).filter(i -> i == 0 || compare(a[i - 1], a[i]) != 0).count();
  }

  static int compare(int[] array1, int[] array2) {
    for (int i = 0; ; ++i) {
      if (i == array1.length && i == array2.length) {
        return 0;
      }
      if (i == array1.length) {
        return -1;
      }
      if (i == array2.length) {
        return 1;
      }
      if (array1[i] < array2[i]) {
        return -1;
      }
      if (array1[i] > array2[i]) {
        return 1;
      }
    }
  }
}