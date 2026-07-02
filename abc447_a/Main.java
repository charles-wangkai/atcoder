import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(solve(N, M) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int N, int M) {
    return M <= (N + 1) / 2;
  }
}