import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A1 = sc.nextInt();
    int A2 = sc.nextInt();
    int A3 = sc.nextInt();

    System.out.println(solve(A1, A2, A3));

    sc.close();
  }

  static String solve(int A1, int A2, int A3) {
    return (A1 + A2 + A3 >= 22) ? "bust" : "win";
  }
}