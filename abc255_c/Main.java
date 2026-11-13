import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long X = sc.nextLong();
    long A = sc.nextLong();
    int D = sc.nextInt();
    long N = sc.nextLong();

    System.out.println(solve(X, A, D, N));

    sc.close();
  }

  static long solve(long X, long A, int D, long N) {
    long first = A;
    long last = A + (N - 1) * D;
    long lower = Math.min(first, last);
    long upper = Math.max(first, last);

    if (X <= lower) {
      return lower - X;
    }
    if (X >= upper) {
      return X - upper;
    }

    int absD = Math.abs(D);

    int diff = Math.abs(Math.floorMod(X, absD) - Math.floorMod(lower, absD));

    return Math.min(diff, absD - diff);
  }
}