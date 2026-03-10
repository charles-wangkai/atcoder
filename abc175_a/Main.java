import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    if (S.equals("RRR")) {
      return 3;
    }
    if (S.contains("RR")) {
      return 2;
    }
    if (S.contains("R")) {
      return 1;
    }

    return 0;
  }
}