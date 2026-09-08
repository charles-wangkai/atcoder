import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static long solve(long N) {
    if (N % 2 == 1) {
      return 0;
    }

    long result = 0;
    for (long i = N / 2; i != 0; i /= 5) {
      result += i / 5;
    }

    return result;
  }
}