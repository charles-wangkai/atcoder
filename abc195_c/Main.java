import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static long solve(long N) {
    long result = 0;
    int digitNum = 1;
    long start = 1;
    long valueNum = 9;
    while (digitNum < String.valueOf(N).length()) {
      result += computeCommaNum(digitNum) * valueNum;

      ++digitNum;
      start *= 10;
      valueNum *= 10;
    }
    result += computeCommaNum(digitNum) * (N - start + 1);

    return result;
  }

  static int computeCommaNum(int digitNum) {
    return (digitNum - 1) / 3;
  }
}