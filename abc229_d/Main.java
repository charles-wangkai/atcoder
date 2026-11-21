import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      String S = sc.next();
      int K = sc.nextInt();

      System.out.println(solve(S, K));
    }
  }

  static int solve(String S, int K) {
    int result = 0;
    int lower = 1;
    int upper = S.length();
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(S, K, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(String S, int K, int length) {
    int dotCount = (int) S.substring(0, length - 1).chars().filter(c -> c == '.').count();
    for (int i = length - 1; i < S.length(); ++i) {
      if (S.charAt(i) == '.') {
        ++dotCount;
      }

      if (dotCount <= K) {
        return true;
      }

      if (S.charAt(i - length + 1) == '.') {
        --dotCount;
      }
    }

    return false;
  }
}