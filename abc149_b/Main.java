import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long A = sc.nextLong();
    long B = sc.nextLong();
    long K = sc.nextLong();

    System.out.println(solve(A, B, K));

    sc.close();
  }

  static String solve(long A, long B, long K) {
    long aEatNum = Math.min(A, K);
    A -= aEatNum;
    K -= aEatNum;

    long bEatNum = Math.min(B, K);
    B -= bEatNum;
    K -= bEatNum;

    return "%d %d".formatted(A, B);
  }
}