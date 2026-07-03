import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long K = sc.nextLong();

    System.out.println(solve(K));

    sc.close();
  }

  static String solve(long K) {
    return Long.toBinaryString(K).replace('1', '2');
  }
}