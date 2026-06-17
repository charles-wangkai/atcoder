import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static long solve(int N) {
    long[] repunits = new long[12];
    repunits[0] = 1;
    for (int i = 1; i < repunits.length; ++i) {
      repunits[i] = repunits[i - 1] * 10 + 1;
    }

    List<Long> candidates = new ArrayList<>();
    for (long a : repunits) {
      for (long b : repunits) {
        for (long c : repunits) {
          candidates.add(a + b + c);
        }
      }
    }

    return candidates.stream().distinct().sorted().skip(N - 1).findFirst().get();
  }
}