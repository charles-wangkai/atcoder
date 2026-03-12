import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int X = sc.nextInt();
    int Y = sc.nextInt();

    System.out.println(solve(X, Y) ? "Yes" : "No");

    sc.close();
  }

  static boolean solve(int X, int Y) {
    return IntStream.rangeClosed(0, X).anyMatch(i -> i * 2 + (X - i) * 4 == Y);
  }
}