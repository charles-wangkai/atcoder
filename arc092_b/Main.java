import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] a = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    int[] b = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < b.length; ++i) {
      b[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(a, b));
  }

  static int solve(int[] a, int[] b) {
    int result = 0;
    for (int i = 0; i <= 28; ++i) {
      int T = 1 << i;
      if (isXORBitOne(mod2T(a, T), mod2T(b, T), T)) {
        result += T;
      }
    }

    return result;
  }

  static int[] mod2T(int[] values, int T) {
    return Arrays.stream(values).map(x -> x % (2 * T)).toArray();
  }

  static boolean isXORBitOne(int[] a, int[] b, int T) {
    Arrays.sort(b);

    return Arrays.stream(a)
                .map(
                    ai ->
                        findNum(b, T - ai, 2 * T - 1 - ai) + findNum(b, 3 * T - ai, 4 * T - 1 - ai))
                .asLongStream()
                .sum()
            % 2
        == 1;
  }

  static int findNum(int[] b, int minTarget, int maxTarget) {
    return findMaxIndex(b, maxTarget) - findMinIndex(b, minTarget) + 1;
  }

  static int findMaxIndex(int[] b, int maxTarget) {
    int result = -1;
    int lower = 0;
    int upper = b.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (b[middle] <= maxTarget) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static int findMinIndex(int[] b, int minTarget) {
    int result = b.length;
    int lower = 0;
    int upper = b.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (b[middle] >= minTarget) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}