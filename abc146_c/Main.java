import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    long X = sc.nextLong();

    System.out.println(solve(A, B, X));

    sc.close();
  }

  static int solve(int A, int B, long X) {
    int result = 0;
    int lower = 1;
    int upper = 1_000_000_000;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(A, B, X, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int A, int B, long X, int n) {
    return (long) A * n + (long) B * String.valueOf(n).length() <= X;
  }
}