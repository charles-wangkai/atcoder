import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int L = sc.nextInt();
    int R = sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S, L, R));

    sc.close();
  }

  static long solve(String S, int L, int R) {
    int[] counts = new int[26];

    long result = 0;
    for (int i = 0; i < S.length(); ++i) {
      if (i >= L) {
        ++counts[S.charAt(i - L) - 'a'];
      }
      if (i > R) {
        --counts[S.charAt(i - R - 1) - 'a'];
      }

      result += counts[S.charAt(i) - 'a'];
    }

    return result;
  }
}