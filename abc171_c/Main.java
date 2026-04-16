import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(long N) {
    String result = "";
    while (N != 0) {
      result = (char) ((N - 1) % 26 + 'a') + result;
      N = (N - 1) / 26;
    }

    return result;
  }
}