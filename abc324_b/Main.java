import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(long N) {
    for (int divisor : new int[] {2, 3}) {
      while (N % divisor == 0) {
        N /= divisor;
      }
    }

    return N == 1;
  }
}