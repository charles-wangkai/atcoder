import java.util.Scanner;

public class Main {
  static final String DECIMAL =
      "1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    return "3.%s".formatted(DECIMAL.substring(0, N));
  }
}