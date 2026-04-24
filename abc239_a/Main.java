import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int H = sc.nextInt();

    System.out.println("%.9f".formatted(solve(H)));

    sc.close();
  }

  static double solve(int H) {
    return Math.sqrt(H * (12_800_000L + H));
  }
}