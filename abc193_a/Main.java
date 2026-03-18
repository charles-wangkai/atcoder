import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println("%.9f".formatted(solve(A, B)));

    sc.close();
  }

  static double solve(int A, int B) {
    return (1 - (double) B / A) * 100;
  }
}