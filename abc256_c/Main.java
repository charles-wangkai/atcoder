import java.util.Scanner;

public class Main {
  static final int LIMIT = 30;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int h1 = sc.nextInt();
    int h2 = sc.nextInt();
    int h3 = sc.nextInt();
    int w1 = sc.nextInt();
    int w2 = sc.nextInt();
    int w3 = sc.nextInt();

    System.out.println(solve(h1, h2, h3, w1, w2, w3));

    sc.close();
  }

  static int solve(int h1, int h2, int h3, int w1, int w2, int w3) {
    int result = 0;

    for (int v00 = 1; v00 <= LIMIT; ++v00) {
      for (int v01 = 1; v01 <= LIMIT; ++v01) {
        for (int v10 = 1; v10 <= LIMIT; ++v10) {
          for (int v11 = 1; v11 <= LIMIT; ++v11) {
            if (check(h1, h2, h3, w1, w2, w3, v00, v01, v10, v11)) {
              ++result;
            }
          }
        }
      }
    }

    return result;
  }

  static boolean check(
      int h1, int h2, int h3, int w1, int w2, int w3, int v00, int v01, int v10, int v11) {
    int v02 = h1 - v00 - v01;
    int v12 = h2 - v10 - v11;
    int v20 = w1 - v00 - v10;
    int v21 = w2 - v01 - v11;
    int v22 = h3 - v20 - v21;

    return v02 + v12 + v22 == w3 && v02 > 0 && v12 > 0 && v20 > 0 && v21 > 0 && v22 > 0;
  }
}