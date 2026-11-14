import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      sc.nextInt();
      String S = sc.next();

      System.out.println(solve(S));
    }
  }

  static int solve(String S) {
    int result = 0;
    int count = 0;
    for (char c : S.toCharArray()) {
      if (c == 'R') {
        ++count;
        result = Math.max(result, count);
      } else {
        count = 0;
      }
    }

    return result;
  }
}