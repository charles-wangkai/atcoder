import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long X = sc.nextLong();

    System.out.println(solve(X));

    sc.close();
  }

  static long solve(long X) {
    return Math.floorDiv(X, 10);
  }
}