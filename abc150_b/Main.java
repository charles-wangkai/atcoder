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
    int result = 0;
    int fromIndex = 0;
    while (true) {
      int index = S.indexOf("ABC", fromIndex);
      if (index == -1) {
        break;
      }

      ++result;
      fromIndex = index + 1;
    }

    return result;
  }
}