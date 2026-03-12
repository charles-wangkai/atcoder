import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();
    long K = sc.nextLong();

    System.out.println(solve(N, K));

    sc.close();
  }

  static long solve(long N, long K) {
    long remainder = N % K;

    return Math.min(remainder, K - remainder);
  }
}