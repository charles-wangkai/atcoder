import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    System.out.println(solve(N, M));

    sc.close();
  }

  static String solve(int N, int M) {
    return IntStream.rangeClosed(1, N)
        .mapToObj(i -> (i <= M) ? "OK" : "Too Many Requests")
        .collect(Collectors.joining("\n"));
  }
}