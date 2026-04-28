import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(long N) {
    StringBuilder result = new StringBuilder();
    while (N != 0) {
      if (N % 2 == 0) {
        result.append('B');
        N /= 2;
      } else {
        result.append('A');
        --N;
      }
    }
    result.reverse();

    return result.toString();
  }
}