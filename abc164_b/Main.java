import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    int D = sc.nextInt();

    System.out.println(solve(A, B, C, D) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int A, int B, int C, int D) {
    boolean firstTurn = true;
    while (true) {
      if (firstTurn) {
        C -= B;
        if (C <= 0) {
          return true;
        }
      } else {
        A -= D;
        if (A <= 0) {
          return false;
        }
      }

      firstTurn = !firstTurn;
    }
  }
}
