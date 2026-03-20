import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int A, int B) {
    int milkSolids = A + B;

    if (milkSolids >= 15 && B >= 8) {
      return 1;
    }
    if (milkSolids >= 10 && B >= 3) {
      return 2;
    }
    if (milkSolids >= 3) {
      return 3;
    }

    return 4;
  }
}