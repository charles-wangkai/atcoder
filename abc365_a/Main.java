import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int Y = sc.nextInt();

    System.out.println(solve(Y));

    sc.close();
  }

  static int solve(int Y) {
    return (Y % 4 == 0 && (Y % 100 != 0 || Y % 400 == 0)) ? 366 : 365;
  }
}