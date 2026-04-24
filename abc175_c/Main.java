import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long X = sc.nextLong();
    long K = sc.nextLong();
    long D = sc.nextLong();

    System.out.println(solve(X, K, D));

    sc.close();
  }

  static long solve(long X, long K, long D) {
    X = Math.abs(X);

    long step = Math.min(K, X / D);
    K -= step;
    X -= D * step;
    if (K % 2 == 1) {
      X = Math.abs(X - D);
    }

    return X;
  }
}