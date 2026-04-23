import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int L = sc.nextInt();
    int R = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(L, R, S));

    sc.close();
  }

  static String solve(int L, int R, String S) {
    char[] letters = S.toCharArray();
    for (int i = L - 1, j = R - 1; i < j; ++i, --j) {
      char temp = letters[i];
      letters[i] = letters[j];
      letters[j] = temp;
    }

    return String.valueOf(letters);
  }
}