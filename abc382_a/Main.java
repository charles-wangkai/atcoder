import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int D = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, D));

    sc.close();
  }

  static int solve(String S, int D) {
    return (int) S.chars().filter(c -> c == '.').count() + D;
  }
}