import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int R = sc.nextInt();
    int X = sc.nextInt();

    System.out.println(solve(R, X) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int R, int X) {
    return (X == 1) ? (R >= 1600 && R <= 2999) : (R >= 1200 && R <= 2399);
  }
}