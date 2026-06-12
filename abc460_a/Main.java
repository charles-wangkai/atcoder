import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(solve(N, M));

    sc.close();
  }

  static int solve(int N, int M) {
    int result = 0;
    while (M != 0) {
      M = N % M;
      ++result;
    }

    return result;
  }
}