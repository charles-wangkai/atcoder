import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int L = sc.nextInt();
    int R = sc.nextInt();

    System.out.println(solve(L, R));

    sc.close();
  }

  static String solve(int L, int R) {
    return "atcoder".substring(L - 1, R);
  }
}