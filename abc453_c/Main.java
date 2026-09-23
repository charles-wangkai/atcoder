import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] L = new int[N];
    for (int i = 0; i < L.length; ++i) {
      L[i] = sc.nextInt();
    }

    System.out.println(solve(L));

    sc.close();
  }

  static int solve(int[] L) {
    return IntStream.range(0, 1 << L.length)
        .map(
            mask -> {
              int result = 0;
              long pos = 1;
              for (int i = 0; i < L.length; ++i) {
                long nextPos = pos + ((((mask >> i) & 1) == 1) ? 1 : -1) * L[i] * 2;
                if (Long.signum(nextPos) != Long.signum(pos)) {
                  ++result;
                }

                pos = nextPos;
              }

              return result;
            })
        .max()
        .getAsInt();
  }
}