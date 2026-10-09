import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[][] a = new int[M][];
    for (int i = 0; i < a.length; ++i) {
      int C = sc.nextInt();
      a[i] = new int[C];
      for (int j = 0; j < a[i].length; ++j) {
        a[i][j] = sc.nextInt();
      }
    }

    System.out.println(solve(N, a));

    sc.close();
  }

  static int solve(int N, int[][] a) {
    return (int)
        IntStream.range(1, 1 << a.length)
            .filter(
                mask ->
                    IntStream.range(0, a.length)
                            .filter(i -> ((mask >> i) & 1) == 1)
                            .flatMap(i -> Arrays.stream(a[i]))
                            .distinct()
                            .count()
                        == N)
            .count();
  }
}