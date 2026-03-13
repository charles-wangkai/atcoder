import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int P = sc.nextInt();

    System.out.println(solve(N, M, P));

    sc.close();
  }

  static int solve(int N, int M, int P) {
    return (int) IntStream.rangeClosed(1, N).filter(i -> i % P == M % P).count();
  }
}