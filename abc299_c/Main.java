import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    String S = sc.next();

    System.out.println(solve(S));

    sc.close();
  }

  static int solve(String S) {
    if (!S.contains("o") || !S.contains("-")) {
      return -1;
    }

    int maxOLength = 0;
    int oLength = 0;
    for (char c : S.toCharArray()) {
      if (c == 'o') {
        ++oLength;
        maxOLength = Math.max(maxOLength, oLength);
      } else {
        oLength = 0;
      }
    }

    return maxOLength;
  }
}