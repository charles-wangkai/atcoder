import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    int result = 0;
    for (int A = 1; A < N; ++A) {
      for (int B = 1; A * B < N; ++B) {
        ++result;
      }
    }

    return result;
  }
}