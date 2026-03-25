import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long A = sc.nextLong();
    double B = sc.nextDouble();

    System.out.println(solve(A, B));

    sc.close();
  }

  static long solve(long A, double B) {
    return A * Math.round(B * 100) / 100;
  }
}