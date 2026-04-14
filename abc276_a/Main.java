import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    int lastIndex = S.lastIndexOf('a');

    return (lastIndex == -1) ? -1 : (lastIndex + 1);
  }
}