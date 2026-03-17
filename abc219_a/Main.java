import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();

    System.out.println(solve(X));

    sc.close();
  }

  static String solve(int X) {
    if (X < 40) {
      return String.valueOf(40 - X);
    }
    if (X < 70) {
      return String.valueOf(70 - X);
    }
    if (X < 90) {
      return String.valueOf(90 - X);
    }

    return "expert";
  }
}