import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int D = sc.nextInt();

    System.out.println(solve(A, D) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int A, int D) {
    return A <= D;
  }
}