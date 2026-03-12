import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int A, int B) {
    return pow(A, B) + pow(B, A);
  }

  static int pow(int base, int exponent) {
    return IntStream.range(0, exponent).reduce(1, (acc, x) -> acc * base);
  }
}