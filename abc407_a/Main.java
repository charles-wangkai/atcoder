import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();

    System.out.println(solve(A, B));

    sc.close();
  }

  static int solve(int A, int B) {
    double value = (double) A / B;
    int floor = (int) Math.floor(value);
    int ceil = (int) Math.ceil(value);

    return (value - floor < ceil - value) ? floor : ceil;
  }
}