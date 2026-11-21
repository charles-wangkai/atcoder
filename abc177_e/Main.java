import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int N = sc.nextInt();
      int[] A = new int[N];
      for (int i = 0; i < A.length; ++i) {
        A[i] = sc.nextInt();
      }

      System.out.println(solve(A));
    }
  }

  static String solve(int[] A) {
    if (Arrays.stream(A).reduce(Main::gcd).getAsInt() != 1) {
      return "not coprime";
    }

    Map<Integer, List<Integer>> valueToPrimeFactors = buildValueToPrimeFactors(A);

    @SuppressWarnings("unchecked")
    List<Integer>[] primeFactorLists =
        Arrays.stream(A).mapToObj(valueToPrimeFactors::get).toArray(List[]::new);

    return (Arrays.stream(primeFactorLists).flatMap(List::stream).distinct().count()
            == Arrays.stream(primeFactorLists).mapToInt(List::size).sum())
        ? "pairwise coprime"
        : "setwise coprime";
  }

  static Map<Integer, List<Integer>> buildValueToPrimeFactors(int[] A) {
    Map<Integer, List<Integer>> valueToPrimeFactors = new HashMap<>();
    for (int Ai : A) {
      valueToPrimeFactors.put(Ai, new ArrayList<>());
    }

    boolean[] primes = new boolean[Arrays.stream(A).max().getAsInt() + 1];
    Arrays.fill(primes, true);
    for (int i = 2; i < primes.length; ++i) {
      if (primes[i]) {
        for (int j = i; j < primes.length; j += i) {
          if (valueToPrimeFactors.containsKey(j)) {
            valueToPrimeFactors.get(j).add(i);
          }

          primes[j] = false;
        }
      }
    }

    return valueToPrimeFactors;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}