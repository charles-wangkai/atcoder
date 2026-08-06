import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();
    int L = sc.nextInt();
    int R = sc.nextInt();
    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(X, Y, L, R, A, B));

    sc.close();
  }

  static int solve(int X, int Y, int L, int R, int A, int B) {
    int result = 0;
    for (int i = A; i < B; ++i) {
      result += (i >= L && i < R) ? X : Y;
    }

    return result;
  }
}