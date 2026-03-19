import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int L = sc.nextInt();

    System.out.println("%.9f".formatted(solve(L)));

    sc.close();
  }

  static double solve(int L) {
    double side = L / 3.0;

    return side * side * side;
  }
}