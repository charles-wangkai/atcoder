import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static long solve(String S) {
    int wCount = (int) S.chars().filter(c -> c == 'W').count();

    long result = 0;
    for (char c : S.toCharArray()) {
      if (c == 'B') {
        result += wCount;
      } else {
        --wCount;
      }
    }

    return result;
  }
}