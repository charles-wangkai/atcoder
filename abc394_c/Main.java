import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    char[] letters = S.toCharArray();
    for (int i = 0; i < letters.length - 1; ++i) {
      for (int j = i; j >= 0 && letters[j] == 'W' && letters[j + 1] == 'A'; --j) {
        letters[j] = 'A';
        letters[j + 1] = 'C';
      }
    }

    return String.valueOf(letters);
  }
}