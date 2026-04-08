import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    int X = sc.nextInt();

    System.out.println("%.9f".formatted(solve(A, B, C, X)));

    sc.close();
  }

  static double solve(int A, int B, int C, int X) {
    if (X <= A) {
      return 1;
    }
    if (X <= B) {
      return (double) C / (B - A);
    }

    return 0;
  }
}