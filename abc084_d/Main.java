import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 100_000;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int Q = sc.nextInt();
    int[] l = new int[Q];
    int[] r = new int[Q];
    for (int i = 0; i < Q; ++i) {
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
    }

    System.out.println(solve(l, r));

    sc.close();
  }

  static String solve(int[] l, int[] r) {
    boolean[] primes = buildPrimes();

    boolean[] similars = new boolean[LIMIT + 1];
    for (int i = 0; i < similars.length; ++i) {
      similars[i] = (i % 2 == 1) && primes[i] && primes[(i + 1) / 2];
    }

    int[] prefixSums = new int[LIMIT + 1];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = ((i == 0) ? 0 : prefixSums[i - 1]) + (similars[i] ? 1 : 0);
    }

    return IntStream.range(0, l.length)
        .map(i -> prefixSums[r[i]] - prefixSums[l[i] - 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static boolean[] buildPrimes() {
    boolean[] primes = new boolean[LIMIT + 1];
    Arrays.fill(primes, true);
    primes[0] = false;
    primes[1] = false;

    for (int i = 2; i < primes.length; ++i) {
      if (primes[i]) {
        for (int j = 2 * i; j < primes.length; j += i) {
          primes[j] = false;
        }
      }
    }

    return primes;
  }
}