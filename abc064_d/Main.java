import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static String solve(String S) {
    int prefixLength = 0;
    int depth = 0;
    for (char c : S.toCharArray()) {
      if (c == '(') {
        ++depth;
      } else if (depth == 0) {
        ++prefixLength;
      } else {
        --depth;
      }
    }

    return "(".repeat(prefixLength) + S + ")".repeat(depth);
  }
}