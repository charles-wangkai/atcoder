import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int A = sc.nextInt();

    System.out.println(solve(N, K, A));

    sc.close();
  }

  static int solve(int N, int K, int A) {
    return (A - 1 + (K - 1)) % N + 1;
  }
}