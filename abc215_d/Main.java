import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, M));

    sc.close();
  }

  static String solve(int[] A, int M) {
    int[] primeFactors =
        Arrays.stream(A)
            .flatMap(Ai -> buildPrimeFactors(Ai).stream().mapToInt(Integer::intValue))
            .distinct()
            .toArray();

    boolean[] excluded = new boolean[M + 1];
    for (int primeFactor : primeFactors) {
      for (int i = primeFactor; i < excluded.length; i += primeFactor) {
        excluded[i] = true;
      }
    }

    int[] satisfied = IntStream.range(1, excluded.length).filter(i -> !excluded[i]).toArray();

    return "%d\n%s"
        .formatted(
            satisfied.length,
            Arrays.stream(satisfied).mapToObj(String::valueOf).collect(Collectors.joining("\n")));
  }

  static List<Integer> buildPrimeFactors(int x) {
    List<Integer> primeFactors = new ArrayList<>();
    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        primeFactors.add(i);

        while (x % i == 0) {
          x /= i;
        }
      }
    }
    if (x != 1) {
      primeFactors.add(x);
    }

    return primeFactors;
  }
}