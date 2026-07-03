import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    long B = sc.nextLong();
    long N = sc.nextLong();

    System.out.println(solve(A, B, N));

    sc.close();
  }

  static long solve(int A, long B, long N) {
    long x = Math.min(B - 1, N);

    return A * x / B - A * (x / B);
  }
}