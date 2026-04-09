import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    char[] result = new char[N];
    for (int i = 0, j = result.length - 1; i <= j; ++i, --j) {
      if (i == j || i + 1 == j) {
        result[i] = '=';
        result[j] = '=';
      } else {
        result[i] = '-';
        result[j] = '-';
      }
    }

    return String.valueOf(result);
  }
}