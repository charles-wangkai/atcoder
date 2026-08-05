import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int R = sc.nextInt();
    int X = sc.nextInt();
    int Y = sc.nextInt();

    System.out.println(solve(R, X, Y));

    sc.close();
  }

  static long solve(int R, int X, int Y) {
    if ((long) X * X + (long) Y * Y < (long) R * R) {
      return 2;
    }

    int result = -1;
    int lower = 1;
    int upper = (int) Math.ceil(Math.sqrt(((long) X * X + (long) Y * Y)) / R);
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if ((long) R * R * middle * middle >= (long) X * X + (long) Y * Y) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}