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
        .mapToObj(i -> (i % 3 == 0) ? "Fizz" : String.valueOf(i))
        .collect(Collectors.joining("\n"));
  }
}