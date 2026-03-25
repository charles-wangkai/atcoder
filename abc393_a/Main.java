import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S1 = sc.next();
    String S2 = sc.next();

    System.out.println(solve(S1, S2));

    sc.close();
  }

  static int solve(String S1, String S2) {
    if (S1.equals("sick")) {
      return S2.equals("sick") ? 1 : 2;
    }

    return S2.equals("sick") ? 3 : 4;
  }
}