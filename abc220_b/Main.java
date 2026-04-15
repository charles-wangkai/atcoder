import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int K = sc.nextInt();
    String A = sc.next();
    String B = sc.next();

    System.out.println(solve(K, A, B));

    sc.close();
  }

  static long solve(int K, String A, String B) {
    return (long) Integer.parseInt(A, K) * Integer.parseInt(B, K);
  }
}