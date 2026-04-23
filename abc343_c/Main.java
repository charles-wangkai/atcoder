import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static long solve(long N) {
    long result = -1;
    for (int i = 1; (long) i * i * i <= N; ++i) {
      long power = (long) i * i * i;
      if (isPalindrome(String.valueOf(power))) {
        result = power;
      }
    }

    return result;
  }

  static boolean isPalindrome(String s) {
    return new StringBuilder(s).reverse().toString().equals(s);
  }
}