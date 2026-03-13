import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();
    long A = sc.nextLong();
    long B = sc.nextLong();

    System.out.println(solve(N, A, B));

    sc.close();
  }

  static long solve(long N, long A, long B) {
    return N / (A + B) * A + Math.min(A, N % (A + B));
  }
}