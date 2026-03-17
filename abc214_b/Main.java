import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int S = sc.nextInt();
    int T = sc.nextInt();

    System.out.println(solve(S, T));

    sc.close();
  }

  static int solve(int S, int T) {
    int result = 0;
    for (int a = 0; a <= S; ++a) {
      for (int b = 0; b <= S; ++b) {
        for (int c = 0; c <= S; ++c) {
          if (a + b + c <= S && a * b * c <= T) {
            ++result;
          }
        }
      }
    }

    return result;
  }
}