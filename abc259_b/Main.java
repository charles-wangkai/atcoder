// https://en.wikipedia.org/wiki/Rotation_matrix

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int d = sc.nextInt();

    System.out.println(solve(a, b, d));

    sc.close();
  }

  static String solve(int a, int b, int d) {
    return "%.9f %.9f"
        .formatted(
            a * Math.cos(Math.toRadians(d)) - b * Math.sin(Math.toRadians(d)),
            a * Math.sin(Math.toRadians(d)) + b * Math.cos(Math.toRadians(d)));
  }
}