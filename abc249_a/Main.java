import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    int D = sc.nextInt();
    int E = sc.nextInt();
    int F = sc.nextInt();
    int X = sc.nextInt();

    System.out.println(solve(A, B, C, D, E, F, X));

    sc.close();
  }

  static String solve(int A, int B, int C, int D, int E, int F, int X) {
    int takahashi = 0;
    int aoki = 0;
    for (int i = 0; i < X; ++i) {
      if (i % (A + C) < A) {
        takahashi += B;
      }
      if (i % (D + F) < D) {
        aoki += E;
      }
    }

    if (takahashi > aoki) {
      return "Takahashi";
    }
    if (aoki > takahashi) {
      return "Aoki";
    }

    return "Draw";
  }
}