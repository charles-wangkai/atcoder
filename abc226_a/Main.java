import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double X = sc.nextDouble();

    System.out.println(solve(X));

    sc.close();
  }

  static int solve(double X) {
    return (int) Math.round(X);
  }
}