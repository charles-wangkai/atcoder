import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt();
    int B = sc.nextInt();
    int C = sc.nextInt();
    int D = sc.nextInt();
    int E = sc.nextInt();

    System.out.println(solve(A, B, C, D, E));

    sc.close();
  }

  static int solve(int A, int B, int C, int D, int E) {
    return (int) IntStream.of(A, B, C, D, E).distinct().count();
  }
}