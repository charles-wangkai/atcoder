import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    System.out.println(solve(N));

    sc.close();
  }

  static String solve(int N) {
    return IntStream.rangeClosed(1, N)
        .map(i -> N + 1 - i)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(","));
  }
}