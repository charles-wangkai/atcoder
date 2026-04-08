import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] x = new int[N - 1];
    int[] y = new int[N - 1];
    for (int i = 0; i < N - 1; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(x, y));

    sc.close();
  }

  static int solve(int[] x, int[] y) {
    int N = x.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[N];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < x.length; ++i) {
      adjLists[x[i] - 1].add(y[i] - 1);
      adjLists[y[i] - 1].add(x[i] - 1);
    }

    Outcome outcome = search(adjLists, -1, 0);

    return MOD_INT.addMod(outcome.whiteWayNum(), outcome.blackWayNum());
  }

  static Outcome search(List<Integer>[] adjLists, int parent, int node) {
    int whiteWayNum = 1;
    int blackWayNum = 1;
    for (int adj : adjLists[node]) {
      if (adj != parent) {
        Outcome subOutcome = search(adjLists, node, adj);

        whiteWayNum =
            MOD_INT.multiplyMod(
                whiteWayNum, MOD_INT.addMod(subOutcome.whiteWayNum(), subOutcome.blackWayNum()));
        blackWayNum = MOD_INT.multiplyMod(blackWayNum, subOutcome.whiteWayNum());
      }
    }

    return new Outcome(whiteWayNum, blackWayNum);
  }
}

record Outcome(int whiteWayNum, int blackWayNum) {}

class ModInt {
  int modulus;

  ModInt(int modulus) {
    this.modulus = modulus;
  }

  int mod(long x) {
    return Math.floorMod(x, modulus);
  }

  int modInv(int x) {
    return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(modulus)).intValue();
  }

  int addMod(int x, int y) {
    return mod(x + y);
  }

  int multiplyMod(int x, int y) {
    return mod((long) x * y);
  }

  int divideMod(int x, int y) {
    return multiplyMod(x, modInv(y));
  }

  int powMod(int base, long exponent) {
    if (exponent == 0) {
      return 1;
    }

    return multiplyMod(
        (exponent % 2 == 0) ? 1 : base, powMod(multiplyMod(base, base), exponent / 2));
  }
}
