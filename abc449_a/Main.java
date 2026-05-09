import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int D = sc.nextInt();

    System.out.println("%.9f".formatted(solve(D)));

    sc.close();
  }

  static double solve(int D) {
    return Math.PI * (D / 2.0) * (D / 2.0);
  }
}