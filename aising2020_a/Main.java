import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int L = sc.nextInt();
    int R = sc.nextInt();
    int d = sc.nextInt();

    System.out.println(solve(L, R, d));

    sc.close();
  }

  static int solve(int L, int R, int d) {
    return (int) IntStream.rangeClosed(L, R).filter(x -> x % d == 0).count();
  }
}