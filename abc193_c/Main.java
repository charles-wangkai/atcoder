import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static long solve(long N) {
    Set<Long> representables = new HashSet<>();
    for (int a = 2; (long) a * a <= N; ++a) {
      for (long power = (long) a * a; power <= N; power *= a) {
        representables.add(power);
      }
    }

    return N - representables.size();
  }
}