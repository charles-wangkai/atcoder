import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static long solve(String S) {
    long result = 0;
    for (char c : S.toCharArray()) {
      result = result * 26 + (c - 'A' + 1);
    }

    return result;
  }
}