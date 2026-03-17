import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long H = sc.nextLong();

    System.out.println(solve(H));

    sc.close();
  }

  static long solve(long H) {
    if (H == 1) {
      return 1;
    }

    return 1 + 2 * solve(H / 2);
  }
}