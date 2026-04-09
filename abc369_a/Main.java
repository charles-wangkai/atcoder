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
    if (A == B) {
      return 1;
    }

    return 2 + (((A + B) % 2 == 0) ? 1 : 0);
  }
}