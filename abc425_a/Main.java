import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static int solve(int N) {
    return IntStream.rangeClosed(1, N).map(i -> ((i % 2 == 0) ? 1 : -1) * i * i * i).sum();
  }
}