import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int Sx = sc.nextInt();
    int Sy = sc.nextInt();
    int Gx = sc.nextInt();
    int Gy = sc.nextInt();

    System.out.println("%.9f".formatted(solve(Sx, Sy, Gx, Gy)));

    sc.close();
  }

  static double solve(int Sx, int Sy, int Gx, int Gy) {
    return Sx + (Gx - Sx) * ((double) Sy / (Sy + Gy));
  }
}