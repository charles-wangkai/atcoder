import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(long N) {
    Set<Long> divisors = new HashSet<>();
    for (int i = 1; (long) i * i <= N; ++i) {
      if (N % i == 0) {
        divisors.add((long) i);
        divisors.add(N / i);
      }
    }

    return divisors.stream().sorted().map(String::valueOf).collect(Collectors.joining("\n"));
  }
}