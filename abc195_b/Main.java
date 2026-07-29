import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int W = sc.nextInt();

    System.out.println(solve(A, B, W));

    sc.close();
  }

  static String solve(int A, int B, int W) {
    int minNum = Math.ceilDiv(W * 1000, B);
    int maxNum = W * 1000 / A;

    return (minNum <= maxNum) ? "%d %d".formatted(minNum, maxNum) : "UNSATISFIABLE";
  }
}