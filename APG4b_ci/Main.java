import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();

    System.out.println(solve(A, B, C));

    sc.close();
  }

  static int solve(int A, int B, int C) {
    return IntStream.of(A, B, C).max().getAsInt() - IntStream.of(A, B, C).min().getAsInt();
  }
}