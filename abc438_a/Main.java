import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int D = sc.nextInt();
    int F = sc.nextInt();

    System.out.println(solve(D, F));

    sc.close();
  }

  static int solve(int D, int F) {
    while (F <= D) {
      F += 7;
    }

    return F - D;
  }
}