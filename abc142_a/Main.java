import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println("%.9f".formatted(solve(N)));

    sc.close();
  }

  static double solve(int N) {
    return (double) IntStream.rangeClosed(1, N).filter(x -> x % 2 == 1).count() / N;
  }
}