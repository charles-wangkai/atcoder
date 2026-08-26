import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();

    System.out.println(solve(X));

    sc.close();
  }

  static int solve(int X) {
    int[] digits = String.valueOf(X).chars().map(c -> c - '0').toArray();

    int[] counts = new int[10];
    for (int digit : digits) {
      ++counts[digit];
    }

    int result = 0;
    for (int i = 1; ; ++i) {
      if (counts[i] != 0) {
        result = result * 10 + i;
        --counts[i];

        break;
      }
    }
    for (int i = 0; i < counts.length; ++i) {
      for (int j = 0; j < counts[i]; ++j) {
        result = result * 10 + i;
      }
    }

    return result;
  }
}