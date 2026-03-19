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
    return IntStream.rangeClosed(0, N)
        .mapToObj(
            i ->
                IntStream.rangeClosed(1, 9)
                    .filter(j -> N % j == 0 && i % (N / j) == 0)
                    .mapToObj(j -> (char) (j + '0'))
                    .findFirst()
                    .orElse('-'))
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}