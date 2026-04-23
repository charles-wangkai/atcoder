import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] S = new String[N];
    for (int i = 0; i < S.length; ++i) {
      S[i] = sc.next();
    }

    System.out.println(solve(S) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(String[] S) {
    return Arrays.stream(S).filter(Si -> Si.equals("For")).count()
        > Arrays.stream(S).filter(Si -> Si.equals("Against")).count();
  }
}