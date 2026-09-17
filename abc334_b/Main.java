import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long A = sc.nextLong();
    int M = sc.nextInt();
    long L = sc.nextLong();
    long R = sc.nextLong();

    System.out.println(solve(A, M, L, R));

    sc.close();
  }

  static long solve(long A, int M, long L, long R) {
    int offset = Math.floorMod(A, M);

    return Math.floorDiv(R - offset, M) - Math.ceilDiv(L - offset, M) + 1;
  }
}