import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();

    System.out.println(solve(X));

    sc.close();
  }

  static int solve(int X) {
    if (X <= 599) {
      return 8;
    }
    if (X <= 799) {
      return 7;
    }
    if (X <= 999) {
      return 6;
    }
    if (X <= 1199) {
      return 5;
    }
    if (X <= 1399) {
      return 4;
    }
    if (X <= 1599) {
      return 3;
    }
    if (X <= 1799) {
      return 2;
    }

    return 1;
  }
}