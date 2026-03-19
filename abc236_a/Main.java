import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();
    int a = sc.nextInt();
    int b = sc.nextInt();

    System.out.println(solve(S, a, b));

    sc.close();
  }

  static String solve(String S, int a, int b) {
    char[] letters = S.toCharArray();

    char temp = letters[a - 1];
    letters[a - 1] = letters[b - 1];
    letters[b - 1] = temp;

    return String.valueOf(letters);
  }
}