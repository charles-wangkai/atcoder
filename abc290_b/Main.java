import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int K = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, K));

    sc.close();
  }

  static String solve(String S, int K) {
    char[] result = S.toCharArray();
    int count = 0;
    for (int i = 0; i < result.length; ++i) {
      if (result[i] == 'o') {
        if (count == K) {
          result[i] = 'x';
        } else {
          ++count;
        }
      }
    }

    return String.valueOf(result);
  }
}