import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int R = sc.nextInt();
    int C = sc.nextInt();

    System.out.println(solve(R, C));

    sc.close();
  }

  static String solve(int R, int C) {
    return (Math.max(Math.abs(R - 8), Math.abs(C - 8)) % 2 == 0) ? "white" : "black";
  }
}