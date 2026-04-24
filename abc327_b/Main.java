import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 15;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long B = sc.nextLong();

    System.out.println(solve(B));

    sc.close();
  }

  static int solve(long B) {
    return IntStream.rangeClosed(1, LIMIT).filter(i -> pow(i, i) == B).findAny().orElse(-1);
  }

  static long pow(int base, int exponent) {
    long result = 1;
    for (int i = 0; i < exponent; ++i) {
      result *= base;
    }

    return result;
  }
}