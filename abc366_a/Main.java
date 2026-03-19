import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int T = sc.nextInt();
    int A = sc.nextInt();

    System.out.println(solve(N, T, A) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N, int T, int A) {
    return Math.max(T, A) - Math.min(T, A) > N - T - A;
  }
}