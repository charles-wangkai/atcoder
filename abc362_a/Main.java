import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int R = sc.nextInt();
    int G = sc.nextInt();
    int B = sc.nextInt();
    String C = sc.next();

    System.out.println(solve(R, G, B, C));

    sc.close();
  }

  static int solve(int R, int G, int B, String C) {
    if (C.equals("Red")) {
      return Math.min(G, B);
    }
    if (C.equals("Green")) {
      return Math.min(R, B);
    }

    return Math.min(R, G);
  }
}