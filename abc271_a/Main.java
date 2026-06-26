import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    String result = Integer.toHexString(N).toUpperCase();
    result = "0".repeat(2 - result.length()) + result;

    return result;
  }
}